package org.snakeskin.controls

import org.snakeskin.ability.AInvertable
import org.snakeskin.ability.AReadable
import org.snakeskin.logic.scalars.NoScaling
import org.snakeskin.logic.scalars.Scalar

/**
 * @author Zachary Kozar and Cameron Earle
 * @version 5/25/2017
 */
class Axis(override var inverted: Boolean = false, var deadband: Double = -1.0, private val getter: () -> Double): AReadable<Double>, AInvertable {
    var scalar: Scalar = NoScaling
    @Synchronized set

    @Synchronized override fun read(): Double {
        val delta = scalar.scale(getter())

        if (deadband == -1.0 || Math.abs(delta) > deadband)
            return if (inverted) -delta else delta
        return 0.0
    }
}
