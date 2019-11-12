package org.snakeskin.hid.mappings

import org.snakeskin.hid.HIDController

/**
 * @author Cameron Earle
 * @version 8/31/17
 */
class DualAction(id: Int): HIDController(id) {
    object Axes {
        const val LeftX = 0
        const val LeftY = 1
        const val RightX = 2
        const val RightY = 3
    }

    object Buttons {
        const val X = 1
        const val A = 2
        const val B = 3
        const val Y = 4
        const val LeftBumper = 5
        const val RightBumper = 6
        const val LeftTrigger = 7
        const val RightTrigger = 8
        const val Back = 9
        const val Start = 10
        const val LeftStick = 11
        const val RightStick = 12
    }

    object Hats {
        const val DPad = 0
    }

    init {
        addAxis(Axes.LeftX)
        addAxis(Axes.LeftY)
        addAxis(Axes.RightX)
        addAxis(Axes.RightY)

        addButton(Buttons.X)
        addButton(Buttons.A)
        addButton(Buttons.B)
        addButton(Buttons.Y)
        addButton(Buttons.LeftBumper)
        addButton(Buttons.RightBumper)
        addButton(Buttons.LeftTrigger)
        addButton(Buttons.RightTrigger)
        addButton(Buttons.Back)
        addButton(Buttons.Start)
        addButton(Buttons.LeftStick)
        addButton(Buttons.RightStick)

        addHat(Hats.DPad)
    }
}