package org.snakeskin.dsl

/**
 * @author Cameron Earle
 * @version 7/18/17
 */
interface Builder<out T> {
    fun build(): T
}