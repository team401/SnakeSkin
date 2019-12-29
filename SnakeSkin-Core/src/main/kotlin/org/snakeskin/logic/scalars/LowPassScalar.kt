package org.snakeskin.logic.scalars

import org.snakeskin.logic.LowPass

/**
 * @author Cameron Earle
 * @version 9/1/17
 */
class LowPassScalar(smoothing: Double): LowPass(smoothing), IScalar {
    override fun scale(input: Double) = lowPass(input)
}