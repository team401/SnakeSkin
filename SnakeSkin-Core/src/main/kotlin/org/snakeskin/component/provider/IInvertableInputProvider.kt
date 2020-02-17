package org.snakeskin.component.provider

/**
 * Represents an input that can be inverted
 */
interface IInvertableInputProvider {
    /**
     * Inverts the input of the device
     */
    fun invertInput(invert: Boolean)
}