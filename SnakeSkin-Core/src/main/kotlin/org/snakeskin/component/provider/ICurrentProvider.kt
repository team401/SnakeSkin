package org.snakeskin.component.provider

/**
 * Represents a component that can provide output current data
 */
interface ICurrentProvider {
    /**
     * Gets the output current of the component, in amps
     */
    fun getOutputCurrent(): Double
}