package org.snakeskin.hid

import org.snakeskin.hid.provider.IHatValueProvider

class HIDHat(private val provider: IHatValueProvider) {
    fun read(): Int {
        return provider.read()
    }
}