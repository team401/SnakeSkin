package org.snakeskin.auto.steps

import org.snakeskin.measure.time.TimeMeasureSeconds

/**
 * @author Cameron Earle
 * @version 5/11/18
 */
class DelayStep(val time: TimeMeasureSeconds): AutoStep() {
    var startTime = TimeMeasureSeconds(0.0)

    override fun entry(currentTime: TimeMeasureSeconds) {
        startTime = currentTime
    }

    override fun action(currentTime: TimeMeasureSeconds, lastTime: TimeMeasureSeconds): Boolean {
        return (currentTime - startTime >= time)
    }

    override fun exit(currentTime: TimeMeasureSeconds) {}
}