package org.snakeskin.auto.steps

import org.snakeskin.measure.time.TimeMeasureSeconds

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

    override fun entry(currentTime: TimeMeasureSeconds) {
        idx = 0
    }

    override fun action(currentTime: TimeMeasureSeconds, lastTime: TimeMeasureSeconds): Boolean {
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

    override fun exit(currentTime: TimeMeasureSeconds) {
        steps.forEach {
            if (it.stepState != StepState.CONTINUE) {
                it.exit(currentTime)
            }
        }
    }
}