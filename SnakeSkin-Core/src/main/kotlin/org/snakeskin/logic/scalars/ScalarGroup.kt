package org.snakeskin.logic.scalars

/**
 * @author Cameron Earle
 * @version 1/4/18
 */
class ScalarGroup(vararg private val scalars: Scalar): Scalar {
    override fun scale(input: Double): Double {
        var current = input
        scalars.forEach {
            current = it.scale(current)
        }
        return current
    }
}