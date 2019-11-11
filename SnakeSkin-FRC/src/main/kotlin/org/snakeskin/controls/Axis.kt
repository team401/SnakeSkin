package org.snakeskin.controls

import org.snakeskin.ability.AInvertable
import org.snakeskin.ability.AReadable
import org.snakeskin.hid.provider.IAxisValueProvider
import org.snakeskin.logic.scalars.NoScaling
import org.snakeskin.logic.scalars.Scalar
import kotlin.math.abs

/**
 * @author Zachary Kozar and Cameron Earle
 * @version 11/7/19
 */
class Axis(private val provider: IAxisValueProvider,
           private val factoryInvert: Boolean,
           override var inverted: Boolean = false,
           var deadband: Double = -1.0): AInvertable {
    var scalar: Scalar = NoScaling
    @Synchronized set

    @Synchronized fun read(): Double {
        val value = if (factoryInvert) -provider.read() else provider.read()
        val delta = scalar.scale(value)

        if (deadband == -1.0 || abs(delta) > deadband)
            return if (inverted) -delta else delta
        return 0.0
    }

    val default = 0.0
}
