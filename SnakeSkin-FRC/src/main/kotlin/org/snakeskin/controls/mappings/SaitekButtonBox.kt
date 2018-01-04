package org.snakeskin.controls.mappings

import org.snakeskin.controls.Controller

/*
 * snakeskin - Created on 1/4/18
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 1/4/18
 */

class SaitekButtonBox(id: Int): Controller(id) {
    inner class MappingDefinitions: IMappingDefinitions {
        inner class AxesDefinitions: IMappingDefinitions.AxesDefinitions {
            val PITCH_BLUE = addAxis(0)
            val ROLL_BLUE = addAxis(1)
            val YAW_BLUE = addAxis(2)
            val PITCH_RED = addAxis(3)
            val ROLL_RED = addAxis(4)
            val YAW_RED = addAxis(5)
            //TODO check axis numbers
        }
        override val Axes = AxesDefinitions()

        inner class ButtonsDefinitions: IMappingDefinitions.ButtonsDefinitions {
            //TODO populate scroll and stick buttons
        }
        override val Buttons = ButtonsDefinitions()

        inner class HatsDefinitions: IMappingDefinitions.HatsDefinitions {

        }
        override val Hats = HatsDefinitions()
    }
    override val Mapping = MappingDefinitions()

    fun readAxis(axis: MappingDefinitions.AxesDefinitions.() -> Int): Double = readAxis(axis(Mapping.Axes))
    fun readButton(button: MappingDefinitions.ButtonsDefinitions.() -> Int): Boolean = readButton(button(Mapping.Buttons))
}