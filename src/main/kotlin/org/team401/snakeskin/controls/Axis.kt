package org.team401.snakeskin.controls

import org.team401.snakeskin.logic.IReadable


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
class Axis(var inverted: Boolean = false, var deadband: Double = -1.0, private val getter: () -> Double): IReadable<Double> {
    object ScalingMethod {
        val NO_SCALING: (Double) -> Double = { it }
        val SQUARED: (Double) -> Double = { if (it < 0.0) -it*it else it*it }
        val CUBED: (Double) -> Double = { it*it*it }
        val SINE: (Double) -> Double = { if (it < 0.0) -Math.sin(Math.PI/2*it*it) else Math.sin(Math.PI/2*it*it) }
    }

    var scaling = ScalingMethod.NO_SCALING
    private set

    override fun read(): Double {
        val delta = scaling(getter())

        if (deadband == -1.0 || Math.abs(delta) > deadband)
            if (inverted) {
                return -delta
            } else {
                return delta
            }
        return 0.0
    }

    infix fun scale(scale: (Double) -> Double): Axis {
        this.scaling = scale
        return this
    }
}
