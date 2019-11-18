package org.snakeskin.hid.impl

import org.snakeskin.hid.provider.IAxisValueProvider

object NullAxisValueProvider : IAxisValueProvider {
    override fun read(): Double {
        //no-op
        return 0.0
    }

}