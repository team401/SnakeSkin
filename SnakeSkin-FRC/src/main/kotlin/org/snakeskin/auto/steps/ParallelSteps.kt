package org.snakeskin.auto.steps

/*
 * snakeskin - Created on 5/11/18
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 5/11/18
 */
class ParallelSteps(vararg steps: AutoStep): AutoStep() {
    val steps = steps.map { it.create() } //Make sure we copy the incoming auto steps so they don't persist state

    override fun entry(currentTime: Double) {
        done = false
    }

    override fun action(currentTime: Double, lastTime: Double) {
        steps.forEach {
            it.tick(currentTime, lastTime)
        }
        if (steps.all { it.doContinue() } || steps.isEmpty()) {
            done = true
        }
    }

    override fun exit(currentTime: Double) {
        steps.forEach {
            if (it.stepState != AutoStep.StepState.CONTINUE) {
                it.exit(currentTime)
            }
        }
    }
}