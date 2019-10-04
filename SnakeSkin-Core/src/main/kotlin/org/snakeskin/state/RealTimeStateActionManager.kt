package org.snakeskin.state

import org.snakeskin.measure.time.TimeMeasureSeconds
import org.snakeskin.rt.RealTimeTask
import org.snakeskin.runtime.SnakeskinRuntime

class RealTimeStateActionManager(private val rtRunnable: (TimeMeasureSeconds, TimeMeasureSeconds) -> Unit, private val executorName: String? = null): IStateActionManager {
    private val rtTask = object : RealTimeTask(false) {
        override fun action(timestamp: TimeMeasureSeconds, dt: TimeMeasureSeconds) {
            rtRunnable(timestamp, dt)
        }
    }

    init {
        SnakeskinRuntime.registerRealTimeTask(rtTask, executorName)
    }

    override fun startAction() {
        rtTask.enabled = true
    }

    override fun stopAction() {
        rtTask.enabled = false
    }
}