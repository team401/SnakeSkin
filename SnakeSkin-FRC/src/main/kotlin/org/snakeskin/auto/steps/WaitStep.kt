package org.snakeskin.auto.steps

import org.snakeskin.measure.MeasureUnitless
import org.snakeskin.measure.time.TimeMeasureSeconds

/**
 * @author Cameron Earle
 * @version 5/11/18
 */
class WaitStep(private val timeout: TimeMeasureSeconds = TimeMeasureSeconds(-1.0), val condition: () -> Boolean): AutoStep() {
    var startTime = TimeMeasureSeconds(0.0)
    private val hasTimeout = timeout > MeasureUnitless(0.0)

    override fun entry(currentTime: TimeMeasureSeconds) {
        startTime = currentTime
    }

    override fun action(currentTime: TimeMeasureSeconds, lastTime: TimeMeasureSeconds): Boolean {
        return ((hasTimeout && currentTime - startTime >= timeout) || condition())
    }

    override fun exit(currentTime: TimeMeasureSeconds) {}
}