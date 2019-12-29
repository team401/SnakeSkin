package org.snakeskin.logic.scalars

/**
 * @author Cameron Earle
 * @version 9/1/17
 */
object SquareScalar : IScalar {
    override fun scale(input: Double) = if (input < 0.0) -input*input else input*input
}