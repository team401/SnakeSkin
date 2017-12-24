package org.snakeskin.logic

/*
 * SnakeSkin - Created on 5/22/17
 * Author: Zachary Kozar
 *
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at the project root.
 */

/**
 * @author Zachary Kozar
 * @version 5/22/17
 */
interface Switch {

    fun isTriggered(): Boolean
}

fun Switch(boolFunc: () -> Boolean): Switch {
    return object : Switch {
        override fun isTriggered(): Boolean {
            return boolFunc()
        }
    }
}