package org.snakeskin.auto

import org.snakeskin.ability.ATickable
import org.snakeskin.factory.TypeAdapterFactory
import java.lang.reflect.Type

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

class Auto(val name: String, vararg inSteps: Any): ATickable {
    companion object {
        val EMPTY_LAMBDA = {}
        val adapters = TypeAdapterFactory<AutoStep>()
    }
    val steps = arrayListOf<AutoStep>()
    var activeStep = 0
    private set
    var done = false
    private set

    fun add(step: Any) {
        when (step) {
            is AutoStep -> steps.add(step)
            is Function0<*> -> steps.add(LambdaAdapter(step))
            else -> {
                steps.add(adapters.adapt(step) ?: throw IllegalArgumentException("'$step' is not a valid auto step!"))
            }
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
        steps.forEach {
            it.reset()
        }
    }

    override fun tick() {
        if (!done) { //If the auto isn't done
            if (activeStep < steps.size) { //If the desired step is within the number of steps
                steps[activeStep].tick()
                if (steps[activeStep].doContinue()) activeStep++
            } else { //We are out of steps
                done = true //Auto is done
            }
        }
    }
}