package org.snakeskin.auto.steps

/**
 * @author Cameron Earle
 * @version 5/11/18
 */
class LambdaStep(val lambda: () -> Unit): SingleStep() {
    override fun entry(currentTime: Double) {
        lambda()
    }
}