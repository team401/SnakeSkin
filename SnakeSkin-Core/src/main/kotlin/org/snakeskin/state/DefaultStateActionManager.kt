package org.snakeskin.state

import org.snakeskin.executor.impl.NullExecutorTaskHandle
import org.snakeskin.executor.ExceptionHandlingRunnable
import org.snakeskin.executor.IExecutorTaskHandle
import org.snakeskin.measure.time.TimeMeasureSeconds
import org.snakeskin.runtime.SnakeskinRuntime
import java.util.concurrent.locks.ReentrantLock

class DefaultStateActionManager(private val actionRunnable: () -> Unit, override val rate: TimeMeasureSeconds): IStateActionManager {
    private var handle: IExecutorTaskHandle = NullExecutorTaskHandle
    private val executor = SnakeskinRuntime.primaryExecutor

    override val asyncTransition = false

    private val exRunnable = ExceptionHandlingRunnable {
        synchronized(this) {
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
        synchronized(this) {} //Unblocks as soon as lock is free
    }
}