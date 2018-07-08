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
abstract class AutoStep(var done: Boolean = false) {
    private val isSingleStep = done
    enum class StepState {
        ENTRY,
        ACTION,
        EXIT,
        CONTINUE
    }

    var stepState = StepState.ENTRY; private set

    fun reset() {
        stepState = StepState.ENTRY
        if (!isSingleStep) {
            done = false
        }
    }

    fun doContinue() = (stepState == StepState.CONTINUE)

    fun tick(currentTime: Double, lastTime: Double) {
        when (stepState) {
            StepState.ENTRY -> {
                entry(currentTime)
                stepState = StepState.ACTION
            }
            StepState.ACTION -> {
                action(currentTime, lastTime)
                if (done) {
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
    abstract fun action(currentTime: Double, lastTime: Double)

    /**
     * Wraps an AutoStep, essentially allowing copies to be created that maintain their own state
     * while calling the entry, action, and exit methods of the original
     */
    private class AutoStepReference(private val stepIn: AutoStep): AutoStep(stepIn.done) {
        override fun entry(currentTime: Double) {
            stepIn.entry(currentTime)
        }

        override fun action(currentTime: Double, lastTime: Double) {
            stepIn.action(currentTime, lastTime)
        }

        override fun exit(currentTime: Double) {
            stepIn.exit(currentTime)
        }
    }

    /**
     * Creates a copy of this auto step.  Since step instances should not be shared,
     * we use this to ensure that a new copy is created whenever it is needed.
     */
    fun create(): AutoStep {
        return AutoStepReference(this)
    }
}