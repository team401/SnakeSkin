package org.snakeskin.auto.steps

/**
 * @author Cameron Earle
 * @version 5/11/18
 */
class DelayStep(val time: Double): AutoStep() {
    var startTime = 0.0

    override fun entry(currentTime: Double) {
        startTime = currentTime
    }

    override fun action(currentTime: Double, lastTime: Double) {
        done = (currentTime - startTime >= time)
    }

    override fun exit(currentTime: Double) {}
}