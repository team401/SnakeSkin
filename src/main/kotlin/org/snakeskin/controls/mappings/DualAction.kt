package org.snakeskin.controls.mappings

import org.snakeskin.controls.Controller

/*
 * snakeskin - Created on 8/31/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 8/31/17
 */

class DualAction(id: Int): Controller(id) {
    inner class MappingDefinitions: IMappingDefinitions {
        inner class AxesDefinitions: IMappingDefinitions.AxesDefinitions {
            val LEFT_X = addAxis(0)
            val LEFT_Y = addAxis(1)
            val RIGHT_X = addAxis(2)
            val RIGHT_Y = addAxis(3)
        }

        override val Axes = AxesDefinitions()

        inner class ButtonsDefinitions: IMappingDefinitions.ButtonsDefinitions {
            val X = addButton(1)
            val A = addButton(2)
            val B = addButton(3)
            val Y = addButton(4)
            val LEFT_BUMPER = addButton(5)
            val RIGHT_BUMPER = addButton(6)
            val LEFT_TRIGGER = addButton(7)
            val RIGHT_TRIGGER = addButton(8)
            val BACK = addButton(9)
            val START = addButton(10)
            val LEFT_STICK = addButton(11)
            val RIGHT_STICK = addButton(12)
        }

        override val Buttons = ButtonsDefinitions()

        inner class HatsDefinitions: IMappingDefinitions.HatsDefinitions {
            val D_PAD = addHat(0)
        }

        override val Hats = HatsDefinitions()
    }

    override val Mapping = MappingDefinitions()

    fun readAxis(axis: MappingDefinitions.AxesDefinitions.() -> Int): Double = readAxis(axis(Mapping.Axes))
    fun readButton(button: MappingDefinitions.ButtonsDefinitions.() -> Int): Boolean = readButton(button(Mapping.Buttons))
    fun readHat(hat: MappingDefinitions.HatsDefinitions.() -> Int): Int = readHat(hat(Mapping.Hats))
}