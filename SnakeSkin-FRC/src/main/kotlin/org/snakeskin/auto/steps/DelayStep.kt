package org.snakeskin.auto.steps

import org.snakeskin.measure.time.TimeMeasureSeconds

/**
 * @author Cameron Earle
 * @version 5/11/18
 */
class DelayStep(val time: TimeMeasureSeconds): AutoStep() {
    var startTime = 0.0
    private val timeSeconds = time.value

    override fun entry(currentTime: Double) {
        startTime = currentTime
    }

    override fun action(currentTime: Double, lastTime: Double): Boolean {
        return (currentTime - startTime >= timeSeconds)
    }

    override fun exit(currentTime: Double) {}
}