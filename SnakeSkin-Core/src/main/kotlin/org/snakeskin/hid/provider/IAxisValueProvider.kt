package org.snakeskin.hid.provider

/**
 * Represents something that provides an axis value
 */
interface IAxisValueProvider {
    fun read(): Double
}