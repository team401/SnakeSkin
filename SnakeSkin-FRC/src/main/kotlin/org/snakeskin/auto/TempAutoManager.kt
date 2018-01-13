package org.snakeskin.auto

import org.snakeskin.factory.ExecutorFactory
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

/*
 * snakeskin - Created on 1/13/18
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 1/13/18
 */
object TempAutoManager {
    private val executor = ExecutorFactory.getExecutor("Auto")
    private var activeFuture: ScheduledFuture<*>? = null

    lateinit var auto: AutoLoop

    fun start() {
        auto.entry()
        activeFuture = executor.scheduleAtFixedRate(auto.action, 0L, auto.rate, TimeUnit.MILLISECONDS)
    }

    fun stop() {
        activeFuture?.cancel(true)
        auto.exit()
    }
}