package org.snakeskin.controls.mappings

import org.snakeskin.controls.Controller

/**
 * @author Cameron Earle
 * @version 7/16/17
 */
class Extreme3D(id: Int): Controller(id) {
    inner class MappingDefinitions: IMappingDefinitions {
        inner class AxesDefinitions : IMappingDefinitions.AxesDefinitions {
            val YAW = addAxis(0)
            val PITCH = addAxis(1)
            val ROLL = addAxis(2)
            val THROTTLE = addAxis(3, true)
        }

        override val Axes = AxesDefinitions()

        inner class ButtonsDefinitions : IMappingDefinitions.ButtonsDefinitions {
            val TRIGGER = addButton(1)
            val THUMB = addButton(2)
            val STICK_BOTTOM_LEFT = addButton(3)
            val STICK_BOTTOM_RIGHT = addButton(4)
            val STICK_TOP_LEFT = addButton(5)
            val STICK_TOP_RIGHT = addButton(6)
            val BASE_TOP_LEFT = addButton(7)
            val BASE_TOP_RIGHT = addButton(8)
            val BASE_MIDDLE_LEFT = addButton(9)
            val BASE_MIDDLE_RIGHT = addButton(10)
            val BASE_BOTTOM_LEFT = addButton(11)
            val BASE_BOTTOM_RIGHT = addButton(12)
        }

        override val Buttons = ButtonsDefinitions()

        inner class HatsDefinitions : IMappingDefinitions.HatsDefinitions {
            val STICK_HAT = addHat(0)
        }

        override val Hats = HatsDefinitions()
    }
    override val Mapping = MappingDefinitions()

    fun readAxis(axis: MappingDefinitions.AxesDefinitions.() -> Int): Double = readAxis(axis(Mapping.Axes))
    fun readButton(button: MappingDefinitions.ButtonsDefinitions.() -> Int): Boolean = readButton(button(Mapping.Buttons))
    fun readHat(hat: MappingDefinitions.HatsDefinitions.() -> Int): Int = readHat(hat(Mapping.Hats))

}