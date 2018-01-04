package org.snakeskin.logic.scalars

/*
 * snakeskin - Created on 1/4/18
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

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