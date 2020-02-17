package org.snakeskin.component.impl

import org.snakeskin.component.IPneumaticChannel

class NullPneumaticChannel private constructor(): IPneumaticChannel {
    companion object {
        val INSTANCE = NullPneumaticChannel()
        val producer = { INSTANCE }
    }

    override fun setState(state: Boolean) {
        //no-op
    }
}