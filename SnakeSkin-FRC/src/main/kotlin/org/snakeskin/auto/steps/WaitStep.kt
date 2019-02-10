package org.snakeskin.auto.steps

import org.snakeskin.measure.time.TimeMeasureSeconds

/**
 * @author Cameron Earle
 * @version 5/11/18
 */
class WaitStep(timeout: TimeMeasureSeconds = TimeMeasureSeconds(-1.0), val condition: () -> Boolean): AutoStep() {
    var startTime = 0.0
    private val timeoutSeconds = timeout.value

    override fun entry(currentTime: Double) {
        startTime = currentTime
    }

    override fun action(currentTime: Double, lastTime: Double): Boolean {
        return ((timeoutSeconds > 0.0 && currentTime - startTime >= timeoutSeconds) || condition())
    }

    override fun exit(currentTime: Double) {}
}