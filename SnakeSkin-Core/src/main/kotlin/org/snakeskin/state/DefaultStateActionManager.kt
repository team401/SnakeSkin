package org.snakeskin.state

import org.snakeskin.executor.impl.NullExecutorTaskHandle
import org.snakeskin.executor.ExceptionHandlingRunnable
import org.snakeskin.executor.IExecutorTaskHandle
import org.snakeskin.measure.time.TimeMeasureSeconds
import org.snakeskin.runtime.SnakeskinRuntime

class DefaultStateActionManager(private val actionRunnable: ExceptionHandlingRunnable, private val rate: TimeMeasureSeconds): IStateActionManager {
    private var handle: IExecutorTaskHandle = NullExecutorTaskHandle
    private val executor = SnakeskinRuntime.primaryExecutor
    override fun startAction() {
        handle = executor.schedulePeriodicTask(actionRunnable, rate)
    }

    override fun stopAction() {
        handle.stopTask(true)
    }
}