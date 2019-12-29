package org.snakeskin.ability

/**
 * @author Cameron Earle
 * @version 7/30/17
 */
interface IInvertable {
    var inverted: Boolean

    fun invert() {
        inverted = !inverted
    }
}