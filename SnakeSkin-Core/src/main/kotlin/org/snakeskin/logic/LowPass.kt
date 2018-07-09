package org.snakeskin.logic

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