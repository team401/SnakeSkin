package org.snakeskin.hid

import org.snakeskin.hid.provider.IHatValueProvider

class HIDHat(private val provider: IHatValueProvider) {
    internal var registered = false

    fun read(): Int {
        if (!registered) return -1
        return provider.read()
    }
}