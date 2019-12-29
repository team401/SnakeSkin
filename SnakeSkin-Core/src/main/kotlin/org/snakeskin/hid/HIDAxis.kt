package org.snakeskin.hid

import org.snakeskin.ability.IInvertable
import org.snakeskin.hid.provider.IAxisValueProvider
import org.snakeskin.logic.scalars.NoScaling
import org.snakeskin.logic.scalars.IScalar
import kotlin.math.abs

class HIDAxis(private val provider: IAxisValueProvider,
           private val factoryInvert: Boolean,
           override var inverted: Boolean = false,
           var deadband: Double = -1.0): IInvertable {
    internal var registered = false

    var scalar: IScalar = NoScaling
        @Synchronized set

    @Synchronized fun read(): Double {
        if (!registered) return 0.0
        val value = if (factoryInvert) -provider.read() else provider.read()
        val delta = scalar.scale(value)

        if (deadband == -1.0 || abs(delta) > deadband)
            return if (inverted) -delta else delta
        return 0.0
    }

    val default = 0.0
}
