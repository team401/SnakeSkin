package org.snakeskin.executor.impl

import org.snakeskin.executor.ExceptionHandlingRunnable
import org.snakeskin.executor.IExecutor
import org.snakeskin.executor.IExecutorTaskHandle
import org.snakeskin.measure.time.TimeMeasureSeconds
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

/**
 * Implementation of the IExecutor interface that uses a ScheduledExecutorService as the backing executor
 */
class ScheduledExecutorServiceExecutor(private val service: ScheduledExecutorService): IExecutor {
    class TaskHandle(private val future: ScheduledFuture<*>): IExecutorTaskHandle {
        override fun stopTask(interrupt: Boolean) {
            future.cancel(interrupt)
        }

        override fun waitFor() {
            future.get()
        }
    }

    override fun scheduleSingleTaskNow(task: ExceptionHandlingRunnable): IExecutorTaskHandle {
        return TaskHandle(service.schedule(task, 0L, TimeUnit.MILLISECONDS))
    }

    override fun scheduleSingleTask(task: ExceptionHandlingRunnable, delay: TimeMeasureSeconds): IExecutorTaskHandle {
        val delayMs = delay.toMilliseconds().value.toLong()
        require (delayMs > 0) { "Invalid delay parameter '$delay'.  Delay must be at least .001 seconds."}
        return TaskHandle(service.schedule(task, delayMs, TimeUnit.MILLISECONDS))
    }

    override fun schedulePeriodicTask(task: ExceptionHandlingRunnable, rate: TimeMeasureSeconds): IExecutorTaskHandle {
        val rateMs = rate.toMilliseconds().value.toLong()
        require(rateMs > 0) { "Invalid rate parameter '$rate'.  Rate must be at least .001 seconds." }
        return TaskHandle(service.scheduleAtFixedRate(task, 0L, rateMs, TimeUnit.MILLISECONDS))
    }

    protected fun finalize() {
        service.shutdown() //Attempt to shutdown the backing service if the object is being garbage collected
    }
}