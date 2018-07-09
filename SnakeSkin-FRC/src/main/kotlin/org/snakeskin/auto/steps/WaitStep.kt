package org.snakeskin.auto.steps

/**
 * @author Cameron Earle
 * @version 5/11/18
 */
class WaitStep(val timeout: Double = -1.0, val condition: () -> Boolean): AutoStep() {
    var startTime = 0.0

    override fun entry(currentTime: Double) {
        startTime = currentTime
    }

    override fun action(currentTime: Double, lastTime: Double) {
        done = ((timeout > 0.0 && currentTime - startTime >= timeout) || condition())

    }
    override fun exit(currentTime: Double) {}
}