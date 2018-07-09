package org.snakeskin.logic.scalars

/**
 * @author Cameron Earle
 * @version 9/1/17
 */
object NoScaling: Scalar {
    override fun scale(input: Double) = input
}