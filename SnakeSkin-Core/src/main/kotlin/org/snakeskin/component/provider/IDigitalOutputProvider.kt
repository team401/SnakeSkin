package org.snakeskin.component.provider

/**
 * Represents a component that can output a digital signal
 */
interface IDigitalOutputProvider {
    /**
     * Sets the digital state of the component
     */
    fun setState(state: Boolean)
}