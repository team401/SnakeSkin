package org.snakeskin.hid.impl

import org.snakeskin.hid.provider.IButtonValueProvider

object NullButtonValueProvider : IButtonValueProvider {
    override fun read(): Boolean {
        //no-op
        return false
    }
}