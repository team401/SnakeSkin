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

    private var auto: AutoLoop = object : AutoLoop() {
        override val rate = 20L
        override fun startTasks() {}
        override fun stopTasks() {}
        override fun entry(currentTime: Double) {}
        override fun action(currentTime: Double, lastTime: Double) {}
        override fun exit(currentTime: Double) {}
    }

    fun setAutoLoop(loop: AutoLoop) {
        auto.stopTasks()
        auto = loop
        auto.startTasks()
    }

    private fun tick() {
        time = Timer.getFPGATimestamp()
        if (auto.tick(time, lastTime)) {
            stop()
        }
        lastTime = time
    }

    @Synchronized fun start() {
        time = Timer.getFPGATimestamp()
        auto.entry(time)
        wasRunning = true
        lastTime = 0.0
        future = executor.scheduleAtFixedRate(::tick, 0L, auto.rate, TimeUnit.MILLISECONDS)
    }

    @Synchronized fun stop() {
        time = Timer.getFPGATimestamp()
        future?.cancel(true)
        if (wasRunning) {
            auto.exit(time)
        }
        wasRunning = false
    }
}