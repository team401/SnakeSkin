package org.snakeskin.executor.impl

import org.snakeskin.executor.ExceptionHandlingRunnable
import org.snakeskin.executor.IExecutor
import org.snakeskin.executor.IExecutorTaskHandle
import org.snakeskin.measure.time.TimeMeasureSeconds

object NullExecutor : IExecutor {
    override fun scheduleSingleTaskNow(task: ExceptionHandlingRunnable): IExecutorTaskHandle {
        //no-op
        return NullExecutorTaskHandle
    }

    override fun scheduleSingleTask(task: ExceptionHandlingRunnable, delay: TimeMeasureSeconds): IExecutorTaskHandle {
        //no-op
        return NullExecutorTaskHandle
    }

    override fun schedulePeriodicTask(task: ExceptionHandlingRunnable, rate: TimeMeasureSeconds): IExecutorTaskHandle {
        //no-op
        return NullExecutorTaskHandle
    }

}