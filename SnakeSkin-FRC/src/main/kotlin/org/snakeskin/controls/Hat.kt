package org.snakeskin.controls

import org.snakeskin.ability.AReadable
import org.snakeskin.hid.provider.IHatValueProvider

/**
 * @author Cameron Earle
 * @version 11/7/19
 */
class Hat(private val provider: IHatValueProvider) {
    fun read(): Int {
        return provider.read()
    }
}