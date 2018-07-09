package org.snakeskin.logic.scalars

/**
 * @author Cameron Earle
 * @version 9/1/17
 */

object CubicScalar : Scalar {
    override fun scale(input: Double) = input*input*input
}