package org.snakeskin.component.provider

/**
 * Represents an output that can be inverted
 */
interface IInvertableOutputProvider {
    /**
     * Inverts the output of the device
     */
    fun invertOutput(invert: Boolean)
}