package org.snakeskin.hid.provider

/**
 * Represents something that provides a hat value
 */
interface IHatValueProvider {
    fun read(): Int
}