package org.team401.snakeskin.logic

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
class History<T> {
    var last: T? = null; private set
    var current: T? = null; private set

    fun update(newValue: T) {
        last = current
        current = newValue
    }
}