package org.snakeskin.auto

import org.snakeskin.factory.ExecutorFactory
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

/*
 * snakeskin - Created on 1/23/18
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 1/23/18
 */
object AutoManager {
    private val executor = ExecutorFactory.getExecutor("Auto")
    private var activeFuture: ScheduledFuture<*>? = null

    var auto = object : AutoLoop() {
        override val rate = 20L
        override fun entry() {}
        override fun action() {}
        override fun exit() {}
    }

    fun start() {
        auto.entry()
        activeFuture = executor.scheduleAtFixedRate({
            val done = auto.tick()
            if (done) {
                stop()
            }
        }, 0L, auto.rate, TimeUnit.MILLISECONDS)
    }

    fun stop() {
        activeFuture?.cancel(true)
        auto.exit()
    }
}