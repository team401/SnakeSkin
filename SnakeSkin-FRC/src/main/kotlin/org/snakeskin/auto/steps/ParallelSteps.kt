package org.snakeskin.auto.steps

/**
 * @author Cameron Earle
 * @version 5/11/18
 */
class ParallelSteps(vararg val steps: AutoStep): AutoStep() {
    override fun reset() {
        super.reset()
        steps.forEach {
            it.reset()
        }
    }

    override fun entry(currentTime: Double) {
    }

    override fun action(currentTime: Double, lastTime: Double): Boolean {
        steps.forEach {
            it.tick(currentTime, lastTime)
        }
        return (steps.all { it.doContinue() } || steps.isEmpty())
    }

    override fun exit(currentTime: Double) {
        steps.forEach {
            if (it.stepState != AutoStep.StepState.CONTINUE) {
                it.exit(currentTime)
            }
        }
    }
}