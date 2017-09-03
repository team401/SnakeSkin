package org.team401.snakeskin.logic

/*
 * snakeskin - Created on 9/1/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 9/1/17
 */
open class LowPass(private val smoothing: Double) {
    private var smoothedValue = 0.0


    fun lowPass(input: Double): Double {
        smoothedValue += (input - smoothedValue) / smoothing
        return smoothedValue
    }
}