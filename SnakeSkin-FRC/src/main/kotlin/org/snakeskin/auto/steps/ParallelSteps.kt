package org.snakeskin.auto.steps

import org.snakeskin.measure.time.TimeMeasureSeconds

/**
 * @author Cameron Earle
 * @version 5/11/18
 */
class ParallelSteps(private vararg val steps: AutoStep): AutoStep() {
    override fun reset() {
        super.reset()
        steps.forEach {
            it.reset()
        }
    }

    override fun entry(currentTime: TimeMeasureSeconds) {
    }

    override fun action(currentTime: TimeMeasureSeconds, lastTime: TimeMeasureSeconds): Boolean {
        steps.forEach {
            it.tick(currentTime, lastTime)
        }
        return (steps.all { it.doContinue() } || steps.isEmpty())
    }

    override fun exit(currentTime: TimeMeasureSeconds) {
        steps.forEach {
            if (it.stepState != StepState.CONTINUE) {
                it.exit(currentTime)
            }
        }
    }
}