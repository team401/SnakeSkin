package org.snakeskin.hid

import org.snakeskin.ability.AInvertable
import org.snakeskin.hid.provider.IButtonValueProvider

class HIDButton(private val provider: IButtonValueProvider,
             override var inverted: Boolean = false): AInvertable {
    @Synchronized fun read(): Boolean {
        if (inverted)
            return !provider.read()
        return provider.read()
    }
}