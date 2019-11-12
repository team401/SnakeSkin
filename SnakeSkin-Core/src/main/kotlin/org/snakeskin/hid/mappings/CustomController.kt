package org.snakeskin.hid.mappings

import org.snakeskin.hid.HIDController

/**
 * @author Cameron Earle
 * @version 8/31/17
 */
class CustomController(id: Int, numAxes: Int, numButtons: Int, numHats: Int): HIDController(id) {
    init {
        for (i in 0 until numAxes) {
            addAxis(i)
        }
        for (i in 1..numButtons) {
            addButton(i)
        }
        for (i in 0 until numHats) {
            addHat(i)
        }
    }
}