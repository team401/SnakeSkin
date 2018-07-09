package org.snakeskin.registry

import org.snakeskin.annotation.PostStartup

/**
 * @author Cameron Earle
 * @version 8/18/17
 */
abstract class Registry<T> {
    protected val registry = arrayListOf<T>()

    /**
     * Adds items to the registry
     * @param items The items to add to the registry
     */
    fun add(vararg items: T) {
        registry.addAll(items)
    }
}