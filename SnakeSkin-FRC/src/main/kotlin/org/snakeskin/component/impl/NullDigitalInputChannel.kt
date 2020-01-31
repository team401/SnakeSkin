package org.snakeskin.component.impl

import org.snakeskin.component.IDigitalInputChannel

/**
 * No-op implementation of a digital input
 */
open class NullDigitalInputChannel private constructor(): IDigitalInputChannel {
    companion object {
        val INSTANCE = NullDigitalInputChannel()
    }

    override fun getState(): Boolean {
        return false
    }
}