package org.snakeskin.state

import org.snakeskin.executor.impl.NullExecutorTaskHandle
import org.snakeskin.executor.ExceptionHandlingRunnable
import org.snakeskin.executor.IExecutorTaskHandle
import org.snakeskin.measure.time.TimeMeasureSeconds
import org.snakeskin.runtime.SnakeskinRuntime

class DefaultStateActionManager(private val actionRunnable: () -> Unit, private val rate: TimeMeasureSeconds): IStateActionManager {
    private var handle: IExecutorTaskHandle = NullExecutorTaskHandle
    private val executor = SnakeskinRuntime.primaryExecutor

    private val lock = Object()
    private val exRunnable = ExceptionHandlingRunnable {
        synchronized(lock) {
            actionRunnable()
        }
    }

    override fun startAction() {
        handle = executor.schedulePeriodicTask(exRunnable, rate)
    }

    override fun stopAction() {
        handle.stopTask(false)
    }

    override fun awaitDone() {
        synchronized(lock) {} //Unblocks as soon as lock is free
    }
}