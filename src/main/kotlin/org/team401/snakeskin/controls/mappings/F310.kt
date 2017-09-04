package org.team401.snakeskin.controls.mappings

import org.team401.snakeskin.controls.Controller

/**
 * @author Cameron Earle
 * @version 7/16/17
 */
class F310(id: Int): Controller(id) {
    inner class MappingDefinitions: IMappingDefinitions {
        inner class AxesDefinitions : IMappingDefinitions.AxesDefinitions {
            val LEFT_X = addAxis(0)
            val LEFT_Y = addAxis(1)
            val LEFT_TRIGGER = addAxis(2)
            val RIGHT_TRIGGER = addAxis(3)
            val RIGHT_X = addAxis(4)
            val RIGHT_Y = addAxis(5)
        }

        override val Axes = AxesDefinitions()

        inner class ButtonsDefinitions : IMappingDefinitions.ButtonsDefinitions {
            val A = addButton(1)
            val B = addButton(2)
            val X = addButton(3)
            val Y = addButton(4)
            val LEFT_BUMPER = addButton(5)
            val RIGHT_BUMPER = addButton(6)
            val BACK = addButton(7)
            val START = addButton(8)
            val LEFT_STICK = addButton(9)
            val RIGHT_STICK = addButton(10)
        }

        override val Buttons = ButtonsDefinitions()

        inner class HatsDefinitions : IMappingDefinitions.HatsDefinitions {
            val D_PAD = addHat(0)        }

        override val Hats = HatsDefinitions()
    }
    override val Mapping = MappingDefinitions()

    fun readAxis(axis: MappingDefinitions.AxesDefinitions.() -> Int): Double = readAxis(axis(Mapping.Axes))
    fun readButton(button: MappingDefinitions.ButtonsDefinitions.() -> Int): Boolean = readButton(button(Mapping.Buttons))
    fun readHat(hat: MappingDefinitions.HatsDefinitions.() -> Int): Int = readHat(hat(Mapping.Hats))

}