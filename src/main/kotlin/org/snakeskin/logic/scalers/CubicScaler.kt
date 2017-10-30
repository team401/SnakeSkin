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

object CubicScaler : Scaler {
    override fun scale(input: Double) = input*input*input
}