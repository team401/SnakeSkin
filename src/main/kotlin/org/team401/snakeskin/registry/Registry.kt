package org.team401.snakeskin.registry

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

    fun add(vararg items: T) {
        registry.addAll(items)
    }

    abstract internal fun initAll()
}