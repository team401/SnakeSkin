package org.snakeskin.auto

import edu.wpi.first.wpilibj.Notifier
import edu.wpi.first.wpilibj.Timer
import org.snakeskin.factory.ExecutorFactory
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

/*
 * snakeskin - Created on 4/3/18
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 4/3/18
 */
object AutoManager {
    private val executor = ExecutorFactory.getExecutor("Auto")
    private var future: ScheduledFuture<*>? = null
    private var wasRunning = false
    private var time = 0.0
    private var lastTime = 0.0

    var auto = object : AutoLoop() {
        override val rate = 20L
        override fun entry() {}
        override fun action(currentTime: Double, lastTime: Double) {}
        override fun exit() {}
    }

    private fun tick() {
        time = Timer.getFPGATimestamp()
        if (auto.tick(time, lastTime)) {
            stop()
        }
        lastTime = time
    }

    @Synchronized fun start() {
        auto.entry()
        wasRunning = true
        time = 0.0
        lastTime = 0.0
        future = executor.scheduleAtFixedRate(::tick, 0L, auto.rate, TimeUnit.MILLISECONDS)
    }

    @Synchronized fun stop() {
        future?.cancel(true)
        if (wasRunning) {
            auto.exit()
        }
        wasRunning = false
    }
}