package org.snakeskin.controls

import org.snakeskin.ability.AReadable

/**
 * @author Cameron Earle
 * @version 7/16/17
 */
class Hat(private val getter: () -> Int): AReadable<Int> {
    override fun read() = getter()
}