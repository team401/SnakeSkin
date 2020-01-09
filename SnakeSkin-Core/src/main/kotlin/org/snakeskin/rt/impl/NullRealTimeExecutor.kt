package org.snakeskin.rt.impl

import org.snakeskin.logic.TickedWaitable
import org.snakeskin.measure.time.TimeMeasureSeconds
import org.snakeskin.rt.IRealTimeExecutor
import org.snakeskin.rt.RealTimeTask
import org.snakeskin.rt.TaskRegistrationOrder

object NullRealTimeExecutor : IRealTimeExecutor {
    override val rate = TimeMeasureSeconds(0.0)
    override val dt = TimeMeasureSeconds(0.0)

    override fun registerTask(task: RealTimeTask, order: TaskRegistrationOrder) {
        //no-op
    }

    override fun start() {
        //no-op
    }

    override fun enqueueSignal(waitable: TickedWaitable) {
        //no-op
    }
}