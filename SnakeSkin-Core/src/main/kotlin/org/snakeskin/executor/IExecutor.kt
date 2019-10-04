package org.snakeskin.executor

import org.snakeskin.measure.time.TimeMeasureSeconds

/**
 * Interface representing an executor which can run single or periodic tasks.
 */
interface IExecutor {
    /**
     * Schedules a single task on the executor
     */
    fun scheduleSingleTaskNow(task: ExceptionHandlingRunnable): IExecutorTaskHandle

    /**
     * Schedules a single task on the executor, which will be run after the specified delay has elapsed
     */
    fun scheduleSingleTask(task: ExceptionHandlingRunnable, delay: TimeMeasureSeconds): IExecutorTaskHandle

    /**
     * Schedules a periodic task on the executor
     */
    fun schedulePeriodicTask(task: ExceptionHandlingRunnable, rate: TimeMeasureSeconds): IExecutorTaskHandle
}