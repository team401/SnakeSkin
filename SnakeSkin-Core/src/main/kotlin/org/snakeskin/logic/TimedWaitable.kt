package org.snakeskin.logic

import org.snakeskin.ability.AWaitable
import org.snakeskin.factory.ExecutorFactory
import java.util.concurrent.TimeUnit

/*
 * snakeskin - Created on 8/17/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

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