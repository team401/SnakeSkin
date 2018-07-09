package org.snakeskin.auto.steps

/**
 * @author Cameron Earle
 * @version 5/11/18
 */
abstract class SingleStep: AutoStep(true) {
    override fun action(currentTime: Double, lastTime: Double) {}
    override fun exit(currentTime: Double) {}
}