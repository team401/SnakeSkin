package org.snakeskin.component.provider

/**
 * Represents a device that can be inverted
 */
interface IInvertableProvider {
    /**
     * Inverts the entire device, including inputs and outputs
     */
    fun invert(invert: Boolean)
}