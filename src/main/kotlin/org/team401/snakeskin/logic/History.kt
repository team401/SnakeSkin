package org.team401.snakeskin.logic

import org.team401.snakeskin.ability.AUpdatable

/*
 * snakeskin - Created on 7/18/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 7/18/17
 */

/**
 * A simple class that tracks history of an object
 */
open class History<T>: AUpdatable<T> {
    var last: T? = null; private set
    var current: T? = null; private set

    override fun update(newValue: T) {
        last = current
        current = newValue
    }

    fun changed(): Boolean {
        return (current != last && current != null)
    }
}