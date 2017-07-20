package org.team401.snakeskin.controls.mappings

import org.team401.snakeskin.controls.Controller

/*
 * snakeskin - Created on 7/16/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

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
            val TRIGGER = addButton(0)
            val THUMB = addButton(1)
            val STICK_BOTTOM_LEFT = addButton(2)
            val STICK_BOTTOM_RIGHT = addButton(3)
            val STICK_TOP_LEFT = addButton(4)
            val STICK_TOP_RIGHT = addButton(5)
            val BASE_TOP_LEFT = addButton(6)
            val BASE_TOP_RIGHT = addButton(7)
            val BASE_MIDDLE_LEFT = addButton(8)
            val BASE_MIDDLE_RIGHT = addButton(9)
            val BASE_BOTTOM_LEFT = addButton(10)
            val BASE_BOTTOM_RIGHT = addButton(11)
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