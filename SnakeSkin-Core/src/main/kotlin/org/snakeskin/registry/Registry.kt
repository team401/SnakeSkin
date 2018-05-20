package org.snakeskin.registry

import org.snakeskin.annotation.PostStartup

/*
 * snakeskin - Created on 8/18/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

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