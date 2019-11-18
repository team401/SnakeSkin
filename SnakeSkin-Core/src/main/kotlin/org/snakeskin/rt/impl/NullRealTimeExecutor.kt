package org.snakeskin.rt.impl

import org.snakeskin.measure.time.TimeMeasureSeconds
import org.snakeskin.rt.IRealTimeExecutor
import org.snakeskin.rt.RealTimeTask

object NullRealTimeExecutor : IRealTimeExecutor {
    override val rate = TimeMeasureSeconds(0.0)
    override val dt = TimeMeasureSeconds(0.0)

    override fun registerTask(task: RealTimeTask) {
        //no-op
    }

    override fun start() {
        //no-op
    }

}