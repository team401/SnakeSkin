package org.snakeskin.component.impl

import org.snakeskin.component.IDigitalOutputChannel

class NullDigitalOutputChannel private constructor(): IDigitalOutputChannel {
    companion object {
        val INSTANCE = NullDigitalOutputChannel()
        val producer = { INSTANCE }
    }

    override fun setState(state: Boolean) {
        //no-op
    }
}