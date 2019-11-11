package org.snakeskin.hid.provider

/**
 * Represents something that provides a button value
 */
interface IButtonValueProvider {
    fun read(): Boolean
}