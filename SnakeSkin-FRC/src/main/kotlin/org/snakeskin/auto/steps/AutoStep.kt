package org.snakeskin.auto.steps

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

    fun reset() {
        stepState = StepState.ENTRY
    }

    fun doContinue() = (stepState == StepState.CONTINUE)

    fun tick(currentTime: Double, lastTime: Double) {
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

    abstract fun entry(currentTime: Double)
    abstract fun exit(currentTime: Double)

    /**
     * This function should return true when it is done.  Doing this will allow the sequence to continue
     */
    abstract fun action(currentTime: Double, lastTime: Double): Boolean
}