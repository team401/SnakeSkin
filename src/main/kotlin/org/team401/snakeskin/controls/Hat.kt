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

class Hat(private val getter: () -> Int): IReadable<Int> {
    override fun read() = getter()
}