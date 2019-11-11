package org.snakeskin.controls.mappings

import org.snakeskin.controls.Controller

/**
 * @author Cameron Earle
 * @version 1/4/18
 */
class T16000M(id: Int): Controller(id) {
    inner class MappingDefinitions: IMappingDefinitions {
        inner class AxesDefinitions: IMappingDefinitions.AxesDefinitions {
            val ROLL = addAxis(0)
            val PITCH = addAxis(1)
            val YAW = addAxis(2)
            val THROTTLE = addAxis(3, true)

        }
        override val Axes = AxesDefinitions()

        inner class ButtonsDefinitions: IMappingDefinitions.ButtonsDefinitions {
            val TRIGGER = addButton(1)
            val STICK_BOTTOM = addButton(2)
            val STICK_LEFT = addButton(3)
            val STICK_RIGHT = addButton(4)
            val BASE_LEFT_TOP_1 = addButton(5)
            val BASE_LEFT_TOP_2 = addButton(6)
            val BASE_LEFT_TOP_3 = addButton(7)
            val BASE_LEFT_BOTTOM_3 = addButton(8)
            val BASE_LEFT_BOTTOM_2 = addButton(9)
            val BASE_LEFT_BOTTOM_1 = addButton(10)
            val BASE_RIGHT_TOP_3 = addButton(11)
            val BASE_RIGHT_TOP_2 = addButton(12)
            val BASE_RIGHT_TOP_1 = addButton(13)
            val BASE_RIGHT_BOTTOM_1 = addButton(14)
            val BASE_RIGHT_BOTTOM_2 = addButton(15)
            val BASE_RIGHT_BOTTOM_3 = addButton(16)
        }
        override val Buttons = ButtonsDefinitions()

        inner class HatsDefinitions: IMappingDefinitions.HatsDefinitions {
            val STICK_HAT = addHat(0)
        }
        override val Hats = HatsDefinitions()
    }
    override val Mapping = MappingDefinitions()
}