package org.snakeskin.ability

/**
 * @author Cameron Earle
 * @version 7/18/17
 */
interface AReadable<out T> {
    fun read(): T
}