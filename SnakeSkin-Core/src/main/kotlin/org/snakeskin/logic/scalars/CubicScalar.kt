package org.snakeskin.logic.scalars

/**
 * @author Cameron Earle
 * @version 9/1/17
 */

object CubicScalar : IScalar {
    override fun scale(input: Double) = input*input*input
}