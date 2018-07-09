package org.snakeskin.ability

/**
 * @author Cameron Earle
 * @version 8/15/17
 */
interface AUpdatable<in T> {
    fun update(newValue: T)
}