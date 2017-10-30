package org.snakeskin.controls

import org.snakeskin.ability.AInvertable
import org.snakeskin.ability.AReadable
import org.snakeskin.logic.scalers.NoScaling
import org.snakeskin.logic.scalers.Scaler


/*
 * SnakeSkin - Created on 5/25/2017
 * Author: Zachary Kozar and Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at the project root.
 */

/**
 * @author Zachary Kozar and Cameron Earle
 * @version 5/25/2017
 */
class Axis(override var inverted: Boolean = false, var deadband: Double = -1.0, private val getter: () -> Double): AReadable<Double>, AInvertable {
    var scaler: Scaler = NoScaling
    @Synchronized set

    @Synchronized override fun read(): Double {
        val delta = scaler.scale(getter())

        if (deadband == -1.0 || Math.abs(delta) > deadband)
            return if (inverted) -delta else delta
        return 0.0
    }
}
