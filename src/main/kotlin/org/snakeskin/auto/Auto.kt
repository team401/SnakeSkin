package org.snakeskin.auto

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

class Auto(val name: String, vararg inSteps: AutoStep) {
    val steps = arrayListOf<AutoStep>()

    init {
        inSteps.forEach {
            steps.add(it)
        }
    }
}