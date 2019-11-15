package org.snakeskin.hid

import org.snakeskin.ability.AInvertable
import org.snakeskin.hid.provider.IButtonValueProvider

class HIDButton(private val provider: IButtonValueProvider,
             override var inverted: Boolean = false): AInvertable {
    internal var registered = false

    @Synchronized fun read(): Boolean {
        if (!registered) return inverted
        if (inverted)
            return !provider.read()
        return provider.read()
    }
}