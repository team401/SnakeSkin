package org.snakeskin.component.provider

/**
 * Represents a component which can provide a digital signal
 */
interface IDigitalSignalProvider {
    fun getState(): Boolean
}