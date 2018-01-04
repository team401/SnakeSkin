package org.snakeskin.logic.scalars

import org.snakeskin.logic.LowPass

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
class LowPassScalar(smoothing: Double): LowPass(smoothing), Scalar {
    override fun scale(input: Double) = lowPass(input)
}