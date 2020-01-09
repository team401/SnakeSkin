package org.snakeskin.state

import org.snakeskin.logic.TickedWaitable
import org.snakeskin.measure.time.TimeMeasureSeconds
import org.snakeskin.rt.IRealTimeExecutor
import org.snakeskin.rt.RealTimeTask
import org.snakeskin.runtime.SnakeskinRuntime

class RealTimeStateActionManager(private val rtRunnable: (TimeMeasureSeconds, TimeMeasureSeconds) -> Unit, val executorName: String? = null): IStateActionManager {
    private lateinit var executor: IRealTimeExecutor

    private val rtTask = object : RealTimeTask(false) {
        override fun action(timestamp: TimeMeasureSeconds, dt: TimeMeasureSeconds) {
            rtRunnable(timestamp, dt)
        }
    }

    override fun register() {
        executor = SnakeskinRuntime.getRealTimeExecutor(executorName)
        executor.registerTask(rtTask)
    }

    override fun startAction() {
        rtTask.enabled = true
    }

    override fun stopAction() {
        rtTask.enabled = false
    }

    override fun awaitDone() {
        val waitable = TickedWaitable()
        executor.enqueueSignal(waitable)
        waitable.waitFor()
    }
}