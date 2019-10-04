package org.snakeskin.auto

import org.snakeskin.executor.ExceptionHandlingRunnable
import org.snakeskin.executor.IExecutorTaskHandle
import org.snakeskin.measure.time.TimeMeasureSeconds
import org.snakeskin.runtime.SnakeskinRuntime

/**
 * @author Cameron Earle
 * @version 4/3/18
 */
object AutoManager {
    private val executor = SnakeskinRuntime.primaryExecutor
    private var autoTaskHandle: IExecutorTaskHandle? = null
    private var wasRunning = false
    private var time: TimeMeasureSeconds = TimeMeasureSeconds(0.0)
    private var lastTime: TimeMeasureSeconds = TimeMeasureSeconds(0.0)

    private var auto: AutoLoop = object : AutoLoop() {
        override val rate = TimeMeasureSeconds(0.02)
        override fun startTasks() {}
        override fun stopTasks() {}
        override fun entry(currentTime: TimeMeasureSeconds) {}
        override fun action(currentTime: TimeMeasureSeconds, lastTime: TimeMeasureSeconds) {}
        override fun exit(currentTime: TimeMeasureSeconds) {}
    }

    fun setAutoLoop(loop: AutoLoop) {
        auto.stopTasks()
        auto = loop
        auto.startTasks()
    }

    private fun tick() {
        time = SnakeskinRuntime.timestamp
        if (auto.tick(time, lastTime)) {
            stop()
        }
        lastTime = time
    }

    @Synchronized fun start() {
        time = SnakeskinRuntime.timestamp
        auto.entry(time)
        wasRunning = true
        lastTime = TimeMeasureSeconds(0.0)
        autoTaskHandle = executor.schedulePeriodicTask(ExceptionHandlingRunnable(::tick), auto.rate)
    }

    @Synchronized fun stop() {
        time = SnakeskinRuntime.timestamp

        autoTaskHandle?.stopTask(true)
        if (wasRunning) {
            auto.exit(time)
        }
        wasRunning = false
    }
}