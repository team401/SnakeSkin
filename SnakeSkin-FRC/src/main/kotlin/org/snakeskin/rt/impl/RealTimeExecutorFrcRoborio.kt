package org.snakeskin.rt.impl

import edu.wpi.first.wpilibj.Notifier
import edu.wpi.first.wpilibj.Timer
import org.snakeskin.logic.TickedWaitable
import org.snakeskin.measure.time.TimeMeasureSeconds
import org.snakeskin.rt.IRealTimeExecutor
import org.snakeskin.rt.RealTimeTask
import org.snakeskin.rt.TaskRegistrationOrder
import org.snakeskin.utility.value.AsyncDouble
import java.util.*
import java.util.concurrent.ConcurrentLinkedQueue

class RealTimeExecutorFrcRoborio(rateSeconds: Double): IRealTimeExecutor {
    private val headTasks = arrayListOf<RealTimeTask>()
    private val defaultTasks = arrayListOf<RealTimeTask>()
    private val tailTasks = arrayListOf<RealTimeTask>()
    private lateinit var tasks: Array<RealTimeTask>
    private val signalQueue = ConcurrentLinkedQueue<TickedWaitable>()
    private var lastDt by AsyncDouble(0.0)
    private var lastTime = Timer.getFPGATimestamp()
    private var isRunning = false

    override val rate = TimeMeasureSeconds(rateSeconds)
    override val dt
    get() = TimeMeasureSeconds(lastDt)

    private inner class Task: Runnable {
        override fun run() {
            val time = Timer.getFPGATimestamp()
            val dt = time - lastTime
            val timeMeasure = TimeMeasureSeconds(time)
            val dtMeasure = TimeMeasureSeconds(dt)

            for (task in tasks) {
                if (task.enabled) {
                    task.action(timeMeasure, dtMeasure)
                }
            }

            for (signal in signalQueue) {
                signal.tick() //Tick all waitable signals
            }

            lastTime = time
            lastDt = dt
        }
    }

    private val notifier = Notifier(Task())

    @Synchronized
    override fun registerTask(task: RealTimeTask, order: TaskRegistrationOrder) {
        check(!isRunning) { "Cannot register task to already running RT executor" }

        when (order) {
            TaskRegistrationOrder.HEAD -> headTasks.add(task)
            TaskRegistrationOrder.DEFAULT -> defaultTasks.add(task)
            TaskRegistrationOrder.TAIL -> tailTasks.add(task)
        }
    }

    @Synchronized
    override fun start() {
        check(!isRunning) { "RT Executor is already running" }
        tasks = arrayOf(*(headTasks.toTypedArray()), *(defaultTasks.toTypedArray()), *(tailTasks.toTypedArray()))
        notifier.startPeriodic(rate.value)
    }

    override fun enqueueSignal(waitable: TickedWaitable) {
        signalQueue.add(waitable)
    }
}