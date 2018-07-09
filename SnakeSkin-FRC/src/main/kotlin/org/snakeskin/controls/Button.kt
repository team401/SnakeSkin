package org.snakeskin.controls

import org.snakeskin.ability.AInvertable
import org.snakeskin.ability.AReadable

/**
 * @author Cameron Earle
 * @version 7/16/17
 */
class Button(override var inverted: Boolean = false, private val getter: () -> Boolean): AReadable<Boolean>, AInvertable {
    override fun read(): Boolean {
        if (inverted)
            return !getter()
        return getter()
    }
}