package org.snakeskin.state

import org.snakeskin.logging.LoggerManager
import org.snakeskin.logic.TickedWaitable
import org.snakeskin.measure.time.TimeMeasureSeconds
import org.snakeskin.rt.IRealTimeExecutor
import org.snakeskin.rt.RealTimeTask
import org.snakeskin.runtime.SnakeskinRuntime

class RealTimeStateActionManager(private val rtRunnable: (TimeMeasureSeconds, TimeMeasureSeconds) -> Unit, val executorName: String? = null, val stateName: String): IStateActionManager {
    private lateinit var executor: IRealTimeExecutor
    override val rate: TimeMeasureSeconds
    get() = executor.rate

    private val rtTask = object : RealTimeTask(false) {
        override fun action(timestamp: TimeMeasureSeconds, dt: TimeMeasureSeconds) {
            rtRunnable(timestamp, dt)
        }
    }

    override fun register() {
        try {
            executor = SnakeskinRuntime.getRealTimeExecutor(executorName)
            executor.registerTask(rtTask)
        } catch (e: IllegalStateException) {
            //Throws when the RT executor does not exist
            if (executorName == null) {
                throw IllegalStateException("Attempted to register rtAction for state '$stateName' on uncreated default RT executor", e)
            } else {
                throw IllegalStateException("Attempted to register rtAction for state '$stateName' on uncreated RT executor '$executorName'", e)
            }
        }
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