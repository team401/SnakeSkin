package org.snakeskin.auto

import org.omg.PortableServer.POAHelper

/*
 * snakeskin - Created on 11/7/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 11/7/17
 */

class Auto(val name: String, vararg inSteps: Any) {
    companion object {
        val EMPTY_LAMBDA = {}
    }
    val steps = arrayListOf<AutoStep>()
    var activeStep = 0
    private set
    private var stage = 0;
    var done = false
    private set

    fun add(step: Any) {
        when (step) {
            is AutoStep -> steps.add(step)
            is Function0<*> -> steps.add(LambdaAdapter(step))
            is com.ctre.phoenix.ILoopable -> steps.add(PhoenixAdapter(step))
            else -> throw IllegalArgumentException("'$step' is not a valid auto step!")
        }
    }

    init {
        inSteps.forEach {
            add(it)
        }
    }

    fun reset() {
        activeStep = 0
        done = false
        stage = 0
    }

    fun tick() {
        if (!done) { //If the auto isn't done
            if (activeStep < steps.size) { //If the desired step is within the number of steps
                when (stage) {
                    0 -> { //Stage 0, meaning we should run the entry method for this step
                        steps[activeStep].entry()
                        if (steps[activeStep].action === EMPTY_LAMBDA) {
                            stage = 2 //There is no action, so we are done.  Jump straight to exit
                            steps[activeStep].done = true
                        } else {
                            stage = 1 //Stage 0 is over as soon as entry finishes, so transition to stage 1
                        }
                    }
                    1 -> { //Stage 1, meaning we should run the action method for this step
                        steps[activeStep].action()
                        if (steps[activeStep].done) { //If the step is done
                            stage = 2 //Advance to stage 2.  This only happens once the loop is done
                        }
                    }
                    2 -> { //Stage 2, meaning we should run the exit method and reset for the next step
                        steps[activeStep].exit()
                        stage = 0 //Reset the stage to 0 for the next step
                        activeStep++ //Increment the step counter
                    }
                }
            } else { //We are out of steps
                done = true //Auto is done
            }
        }
    }
}