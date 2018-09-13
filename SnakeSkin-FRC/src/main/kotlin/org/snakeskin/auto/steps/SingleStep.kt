package org.snakeskin.auto.steps

/**
 * @author Cameron Earle
 * @version 5/11/18
 */
abstract class SingleStep: AutoStep() {
    override fun action(currentTime: Double, lastTime: Double): Boolean { return true }
    override fun exit(currentTime: Double) {}
}