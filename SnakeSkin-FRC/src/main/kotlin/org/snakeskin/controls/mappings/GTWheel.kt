package org.snakeskin.controls.mappings

import org.snakeskin.controls.Controller

/**
 * @author Cameron Earle
 * @version 8/31/17
 */
class GTWheel(id: Int, enabled: Boolean = true): Controller(id, enabled) {
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

    inline fun readAxis(axis: MappingDefinitions.AxesDefinitions.() -> Int): Double = readAxis(axis(Mapping.Axes))
    inline fun readButton(button: MappingDefinitions.ButtonsDefinitions.() -> Int): Boolean = readButton(button(Mapping.Buttons))
    inline fun readHat(hat: MappingDefinitions.HatsDefinitions.() -> Int): Int = readHat(hat(Mapping.Hats))
}