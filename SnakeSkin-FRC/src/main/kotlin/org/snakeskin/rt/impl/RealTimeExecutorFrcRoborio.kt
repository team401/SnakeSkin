package org.snakeskin.rt.impl

import edu.wpi.first.wpilibj.Notifier
import edu.wpi.first.wpilibj.Timer
import org.snakeskin.measure.time.TimeMeasureSeconds
import org.snakeskin.rt.IRealTimeExecutor
import org.snakeskin.rt.RealTimeTask
import org.snakeskin.utility.value.AsyncDouble

class RealTimeExecutorFrcRoborio(rateSeconds: Double): IRealTimeExecutor {
    private val tasks = arrayListOf<RealTimeTask>()
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

            lastTime = time
            lastDt = dt
        }
    }

    private val notifier = Notifier(Task())

    @Synchronized
    override fun registerTask(task: RealTimeTask) {
        check(!isRunning) { "Cannot register task to already running RT executor" }
        tasks.add(task)
    }

    @Synchronized
    override fun start() {
        check(!isRunning) { "RT Executor is already running" }
        notifier.startPeriodic(rate.value)
    }
}