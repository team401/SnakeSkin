package org.team401.snakeskin.ability

/**
 * Created by cameronearle on 7/30/2017.
 */

interface AInvertable {
    var inverted: Boolean

    fun invert() {
        inverted = !inverted
    }
}