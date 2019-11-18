package org.snakeskin.hid.impl

import org.snakeskin.hid.provider.IHatValueProvider

object NullHatValueProvider : IHatValueProvider {
    override fun read(): Int {
        //no-op
        return -1
    }
}