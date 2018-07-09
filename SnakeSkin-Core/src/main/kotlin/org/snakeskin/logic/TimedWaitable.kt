package org.snakeskin.logic

import org.snakeskin.ability.AWaitable
import org.snakeskin.factory.ExecutorFactory
import java.util.concurrent.TimeUnit


/**
 * @author Cameron Earle
 * @version 8/17/17
 */
class TimedWaitable(val time: Long): TickedWaitable() {
    private val executor = ExecutorFactory.getExecutor("Timer")

    fun start(): AWaitable {
        executor.schedule({tick()}, time, TimeUnit.MILLISECONDS)
        return this
    }
}