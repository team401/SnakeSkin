package org.snakeskin.controls.mappings

import org.snakeskin.controls.Controller

/**
 * Created by cameronearle on 7/28/2017.
 */

class GTWheel(id: Int): Controller(id) {
    inner class MappingDefinitions: IMappingDefinitions {
        inner class AxesDefinitions : IMappingDefinitions.AxesDefinitions {
            val WHEEL = addAxis(0)
        }

        override val Axes = AxesDefinitions()

        inner class ButtonsDefinitions : IMappingDefinitions.ButtonsDefinitions

        override val Buttons = ButtonsDefinitions()

        inner class HatsDefinitions : IMappingDefinitions.HatsDefinitions

        override val Hats = HatsDefinitions()
    }
    override val Mapping = MappingDefinitions()

    fun readAxis(axis: MappingDefinitions.AxesDefinitions.() -> Int): Double = readAxis(axis(Mapping.Axes))
    fun readButton(button: MappingDefinitions.ButtonsDefinitions.() -> Int): Boolean = readButton(button(Mapping.Buttons))
    fun readHat(hat: MappingDefinitions.HatsDefinitions.() -> Int): Int = readHat(hat(Mapping.Hats))
}