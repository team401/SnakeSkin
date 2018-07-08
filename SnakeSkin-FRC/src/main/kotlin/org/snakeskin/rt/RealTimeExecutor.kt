package org.snakeskin.rt

import edu.wpi.first.wpilibj.Notifier
import edu.wpi.first.wpilibj.Timer
import org.snakeskin.logging.LoggerManager
import org.snakeskin.logic.LockingDelegate
import java.util.concurrent.CopyOnWriteArrayList

/**
 * Uses a Notifier to run a list of real time tasks at a fixed rate.
 * Using the Notifier gives more precise timing than the system clock.
 */
object RealTimeExecutor {
    private var running = false
    private val tasks = CopyOnWriteArrayList<RealTimeTask>()

    /**
     * Rate, in seconds, that the RT executor should run at
     * Defaults to 5ms
     */
    var rate = .005

    class RealTimeContext {
        //These two properties should not be accessed outside of a real time task
        var time = 0.0; private set
        var lastTime = 0.0; private set

        //This property is accessible outside of a real time task, so we need to secure it from simultaneous read/writes
        var dt by LockingDelegate(0.0); private set

        fun updateTime() {
            time = Timer.getFPGATimestamp()
        }

        fun updateDt() {
            dt = time - lastTime
            lastTime = time
        }
    }
    private val context = RealTimeContext()

    private object RealTimeRunnable: Runnable {
        override fun run() {
            if (running) {
                context.updateTime() //Update current time

                for (task: RealTimeTask in tasks) {
                    try {
                        task.action(context) //Run the task
                    } catch (e: Exception) { //If the task fails, log it and remove it from the list of tasks
                        LoggerManager.logThrowable(RealTimeException("Exception in real time task '${task.name}', this task will be cancelled!", e))
                        tasks.remove(task)
                    }
                }

                context.updateDt() //Update dt
            } else {
                throw IllegalStateException("RealTimeExecutor was not started before calling runnable!")
            }
        }
    }

    private val notifier = Notifier(RealTimeRunnable) //Backing notifier

    private fun start() {
        running = true
        notifier.startPeriodic(rate)
    }

    /**
     * Adds a real time task to the list of tasks to run
     */
    fun addTask(task: RealTimeTask) {
        tasks.add(task)
        if (!running) start()
    }

    /**
     * Gets the most recent dt (seconds between last run and this one) value from the executor
     * Useful for analysing how accurately the executor is maintaining the desired rate.  It should be
     * very close to the rate property.  If not, something in your real time code is taking too long and should be removed.
     */
    fun getDt() = context.dt
}