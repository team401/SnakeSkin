package org.snakeskin.logic.scalars

/**
 * @author Cameron Earle
 * @version 9/1/17
 */
object SineScalar : IScalar {
    override fun scale(input: Double) = if (input < 0.0) -Math.sin(Math.PI/2*input*input) else Math.sin(Math.PI/2*input*input)
}