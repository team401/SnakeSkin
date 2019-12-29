package org.snakeskin.dsl

/**
 * @author Cameron Earle
 * @version 7/18/17
 */
interface IBuilder<out T> {
    fun build(): T
}