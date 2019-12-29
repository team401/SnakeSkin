package org.snakeskin.hid

import org.snakeskin.ability.IInvertable
import org.snakeskin.hid.provider.IButtonValueProvider

class HIDButton(private val provider: IButtonValueProvider,
             override var inverted: Boolean = false): IInvertable {
    internal var registered = false

    @Synchronized fun read(): Boolean {
        if (!registered) return inverted
        if (inverted)
            return !provider.read()
        return provider.read()
    }
}