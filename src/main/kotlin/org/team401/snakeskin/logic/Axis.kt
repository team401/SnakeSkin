package org.team401.snakeskin.logic

/*
 * SnakeSkin - Created on 5/25/2017
 * Author: Zachary Kozar
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at the project root.
 */

/**
 * @author Zachary Kozar
 * @version 5/25/2017
 */
class Axis(var deadband: Double = -1.0, private val axis: () -> Double) {

    var scaling: (Double) -> Double = NO_SCALING
        private set

    companion object {
        val NO_SCALING: (Double) -> Double = { it }
        val SQUARED: (Double) -> Double = { if (it < 0.0) -it*it else it*it }
        val CUBED: (Double) -> Double = { it*it*it }
        val SINE: (Double) -> Double = { if (it < 0.0) -Math.sin(Math.PI/2*it*it) else Math.sin(Math.PI/2*it*it) }
    }

    fun read(): Double {
        val delta = scaling(axis())

        if (deadband == -1.0 || Math.abs(delta) > deadband)
            return delta
        return 0.0
    }

    infix fun scale(scale: (Double) -> Double): Axis {
        this.scaling = scale
        return this
    }
}
