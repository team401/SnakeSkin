package org.snakeskin.logic

import org.snakeskin.ability.AWaitable
import org.snakeskin.executor.ExceptionHandlingRunnable
import org.snakeskin.measure.time.TimeMeasureSeconds
import org.snakeskin.runtime.SnakeskinRuntime


/**
 * @author Cameron Earle
 * @version 8/17/17
 */
class TimedWaitable(val time: TimeMeasureSeconds): TickedWaitable() {
    private val task = ExceptionHandlingRunnable(::tick)

    fun start(): AWaitable {
        SnakeskinRuntime.executeTaskAfter(task, time)
        return this
    }
}