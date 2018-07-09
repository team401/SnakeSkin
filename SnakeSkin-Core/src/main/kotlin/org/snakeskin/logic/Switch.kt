package org.snakeskin.logic

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