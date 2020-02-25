package org.snakeskin.component.provider

/**
 * Represents a component which can provide a digital signal
 */
interface IDigitalSignalProvider {
    /**
     * Provides the state of the digital signal
     */
    fun getState(): Boolean
}