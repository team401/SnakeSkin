package org.team401.snakeskin.controls2

/*
 * snakeskin - Created on 7/16/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 7/16/17
 */

class Button(var inverted: Boolean = false, private val getter: () -> Boolean) {
    fun read(): Boolean {
        if (inverted)
            return !getter()
        return getter()
    }
}