package org.snakeskin.state

import org.snakeskin.executor.ExceptionHandlingRunnable
import org.snakeskin.executor.IExecutorTaskHandle
import org.snakeskin.executor.impl.NullExecutorTaskHandle
import org.snakeskin.measure.time.TimeMeasureSeconds
import org.snakeskin.runtime.SnakeskinRuntime
import org.snakeskin.utility.Ticker

class TickedActionManager(condition: () -> Boolean, val actionRunnable: () -> Unit, timeThreshold: TimeMeasureSeconds, override val rate: TimeMeasureSeconds): IStateActionManager {
    private var handle: IExecutorTaskHandle = NullExecutorTaskHandle
    private val executor = SnakeskinRuntime.primaryExecutor

    override val asyncTransition = false

    private val ticker = Ticker(condition, timeThreshold, rate)
    private val exRunnable = ExceptionHandlingRunnable {
        synchronized(this) {
            if (ticker.check()) {
                actionRunnable()
            }
        }
    }

    override fun startAction() {
        ticker.reset()
        handle = executor.schedulePeriodicTask(exRunnable, rate)
    }

    override fun stopAction() {
        handle.stopTask(false)
    }

    override fun awaitDone() {
        synchronized(this) {} //Unblocks as soon as lock is free
    }
}