package org.team401.snakeskin.controls

import org.team401.snakeskin.logic.IReadable

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

class Button(var inverted: Boolean = false, private val getter: () -> Boolean): IReadable<Boolean> {
    override fun read(): Boolean {
        if (inverted)
            return !getter()
        return getter()
    }
}