package org.team401.snakeskin.controls.mappings

import org.team401.snakeskin.controls.Controller

/**
 * Created by cameronearle on 8/4/2017.
 */

class Attack3(id: Int): Controller(id) {
    inner class MappingDefinitions: IMappingDefinitions {
        inner class AxesDefinitions: IMappingDefinitions.AxesDefinitions {
            val ROLL = addAxis(0)
            val PITCH = addAxis(1)
            val THROTTLE = addAxis(2, true)
        }

        override val Axes = AxesDefinitions()

        inner class ButtonsDefinitions: IMappingDefinitions.ButtonsDefinitions {
            val TRIGGER = addButton(1)
            val STICK_BOTTOM = addButton(2)
            val STICK_TOP = addButton(3)
            val STICK_LEFT = addButton(4)
            val STICK_RIGHT = addButton(5)
            val BASE_LEFT_TOP = addButton(6)
            val BASE_LEFT_BOTTOM = addButton(7)
            val BASE_BOTTOM_LEFT = addButton(8)
            val BASE_BOTTOM_RIGHT = addButton(9)
            val BASE_RIGHT_BOTTOM = addButton(10)
            val BASE_RIGHT_TOP = addButton(11)
        }

        override val Buttons = ButtonsDefinitions()

        override val Hats = object : IMappingDefinitions.HatsDefinitions {}
    }

    override val Mapping = MappingDefinitions()

    fun readAxis(axis: MappingDefinitions.AxesDefinitions.() -> Int): Double = readAxis(axis(Mapping.Axes))
    fun readButton(button: MappingDefinitions.ButtonsDefinitions.() -> Int): Boolean = readButton(button(Mapping.Buttons))
}