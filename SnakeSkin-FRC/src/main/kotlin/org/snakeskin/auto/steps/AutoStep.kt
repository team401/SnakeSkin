package org.snakeskin.auto.steps

import org.snakeskin.measure.time.TimeMeasureSeconds

/**
 * @author Cameron Earle
 * @version 5/11/18
 */
abstract class AutoStep {
    enum class StepState {
        ENTRY,
        ACTION,
        EXIT,
        CONTINUE
    }

    var stepState = StepState.ENTRY; private set

    open fun reset() {
        stepState = StepState.ENTRY
    }

    fun doContinue() = (stepState == StepState.CONTINUE)

    fun tick(currentTime: TimeMeasureSeconds, lastTime: TimeMeasureSeconds) {
        when (stepState) {
            StepState.ENTRY -> {
                entry(currentTime)
                stepState = StepState.ACTION
            }
            StepState.ACTION -> {
                if (action(currentTime, lastTime)) {
                    stepState = StepState.EXIT
                }
            }
            StepState.EXIT -> {
                exit(currentTime)
                stepState = StepState.CONTINUE
            }
            else -> {}
        }
    }

    abstract fun entry(currentTime: TimeMeasureSeconds)
    abstract fun exit(currentTime: TimeMeasureSeconds)

    /**
     * This function should return true when it is done.  Doing this will allow the sequence to continue
     */
    abstract fun action(currentTime: TimeMeasureSeconds, lastTime: TimeMeasureSeconds): Boolean
}