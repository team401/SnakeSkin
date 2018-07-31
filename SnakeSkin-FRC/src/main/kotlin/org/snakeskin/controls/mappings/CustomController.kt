package org.snakeskin.controls.mappings

import org.snakeskin.controls.Controller

/**
 * @author Cameron Earle
 * @version 8/31/17
 */
class CustomController(id: Int, numAxes: Int, numButtons: Int, numHats: Int, enabled: Boolean = true): Controller(id, enabled) {
    init {
        for (i in 0 until numAxes) {
            addAxis(i)
        }
        for (i in 1..numButtons) {
            addButton(i)
        }
        for (i in 0 until numHats) {
            addHat(i)
        }
    }

    override val Mapping = object : IMappingDefinitions {
        override val Axes = object : IMappingDefinitions.AxesDefinitions {}
        override val Buttons = object : IMappingDefinitions.ButtonsDefinitions {}
        override val Hats = object : IMappingDefinitions.HatsDefinitions {}
    }
}