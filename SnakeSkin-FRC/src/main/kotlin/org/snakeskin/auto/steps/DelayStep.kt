package org.snakeskin.auto.steps

import org.snakeskin.units.TimeUnit
import org.snakeskin.units.measure.time.TimeMeasure

/**
 * @author Cameron Earle
 * @version 5/11/18
 */
class DelayStep(val time: TimeMeasure): AutoStep() {
    var startTime = 0.0
    private val timeSeconds = time.toUnit(TimeUnit.Standard.SECONDS).value

    override fun entry(currentTime: Double) {
        startTime = currentTime
    }

    override fun action(currentTime: Double, lastTime: Double) {
        done = (currentTime - startTime >= timeSeconds)
    }

    override fun exit(currentTime: Double) {}
}