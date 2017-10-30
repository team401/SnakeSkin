package org.snakeskin.logic.scalers

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

object SineScaler : Scaler {
    override fun scale(input: Double) = if (input < 0.0) -Math.sin(Math.PI/2*input*input) else Math.sin(Math.PI/2*input*input)
}