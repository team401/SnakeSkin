package org.snakeskin.auto.steps

/**
 * @author Cameron Earle
 * @version 5/11/18
 */
class SequentialSteps(vararg steps: AutoStep): AutoStep() {
    val steps = steps.map { it.create() } //Make sure we copy the incoming auto steps so they don't persist state

    private var idx = 0

    override fun entry(currentTime: Double) {
        done = false
        idx = 0
    }

    override fun action(currentTime: Double, lastTime: Double) {
        if (idx < steps.size) {
            steps[idx].tick(currentTime, lastTime)
            if (steps[idx].doContinue()) {
                idx++
            }
        } else {
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