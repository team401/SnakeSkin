package org.snakeskin.controls.mappings

import org.snakeskin.controls.Controller

/**
 * @author Cameron Earle
 * @version 1/4/18
 */
class SaitekButtonBox(id: Int, enabled: Boolean = true): Controller(id, enabled) {
    inner class MappingDefinitions: IMappingDefinitions {
        inner class AxesDefinitions: IMappingDefinitions.AxesDefinitions {
            val ROLL_BLUE = addAxis(0)
            val PITCH_BLUE = addAxis(1)
            val YAW_BLUE = addAxis(2)
            val ROLL_RED = addAxis(3)
            val PITCH_RED = addAxis(4)
            val YAW_RED = addAxis(5)
        }
        override val Axes = AxesDefinitions()

        inner class ButtonsDefinitions: IMappingDefinitions.ButtonsDefinitions {
            init {
                for (i in 1..24) {
                    addButton(i)
                }
            }
            val SCROLL_CLICK = addButton(25)
            val SCROLL_UP = addButton(26)
            val SCROLL_DOWN = addButton(27)
            val STICK_BUTTON = addButton(28)
        }
        override val Buttons = ButtonsDefinitions()

        inner class HatsDefinitions: IMappingDefinitions.HatsDefinitions
        override val Hats = HatsDefinitions()
    }
    override val Mapping = MappingDefinitions()

    fun readAxis(axis: MappingDefinitions.AxesDefinitions.() -> Int): Double = readAxis(axis(Mapping.Axes))
    fun readButton(button: MappingDefinitions.ButtonsDefinitions.() -> Int): Boolean = readButton(button(Mapping.Buttons))
}