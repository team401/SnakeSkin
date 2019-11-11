package org.snakeskin.controls

import org.snakeskin.ability.AInvertable
import org.snakeskin.ability.AReadable
import org.snakeskin.hid.provider.IButtonValueProvider

/**
 * @author Cameron Earle
 * @version 11/7/19
 */
class Button(private val provider: IButtonValueProvider,
             override var inverted: Boolean = false): AInvertable {
    @Synchronized fun read(): Boolean {
        if (inverted)
            return !provider.read()
        return provider.read()
    }
}