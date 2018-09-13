package org.snakeskin.auto.steps

/**
 * @author Cameron Earle
 * @version 5/11/18
 */
class SequentialSteps(vararg val steps: AutoStep): AutoStep() {
    private var idx = 0

    override fun reset() {
        super.reset()
        steps.forEach {
            it.reset()
        }
    }

    override fun entry(currentTime: Double) {
        idx = 0
    }

    override fun action(currentTime: Double, lastTime: Double): Boolean {
        if (idx < steps.size) {
            steps[idx].tick(currentTime, lastTime)
            if (steps[idx].doContinue()) {
                idx++
            }
        } else {
            return true
        }
        return false
    }

    override fun exit(currentTime: Double) {
        steps.forEach {
            if (it.stepState != AutoStep.StepState.CONTINUE) {
                it.exit(currentTime)
            }
        }
    }
}