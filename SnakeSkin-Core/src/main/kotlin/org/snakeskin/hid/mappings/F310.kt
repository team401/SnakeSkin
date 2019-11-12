package org.snakeskin.hid.mappings

import org.snakeskin.hid.HIDController

/**
 * @author Cameron Earle
 * @version 7/16/17
 */
class F310(id: Int): HIDController(id) {
    object Axes {
        const val LeftX = 0
        const val LeftY = 1
        const val LeftTrigger = 2
        const val RightTrigger = 3
        const val RightX = 4
        const val RightY = 5
    }

    object Buttons {
        const val A = 1
        const val B = 2
        const val X = 3
        const val Y = 4
        const val LeftBumper = 5
        const val RightBumper = 6
        const val Back = 7
        const val Start = 8
        const val LeftStick = 9
        const val RightStick = 10
    }

    object Hats {
        const val DPad = 0
    }

    init {
        addAxis(Axes.LeftX)
        addAxis(Axes.LeftY)
        addAxis(Axes.LeftTrigger)
        addAxis(Axes.RightTrigger)
        addAxis(Axes.RightX)
        addAxis(Axes.RightY)

        addButton(Buttons.A)
        addButton(Buttons.B)
        addButton(Buttons.X)
        addButton(Buttons.Y)
        addButton(Buttons.LeftBumper)
        addButton(Buttons.RightBumper)
        addButton(Buttons.Back)
        addButton(Buttons.Start)
        addButton(Buttons.LeftStick)
        addButton(Buttons.RightStick)

        addHat(Hats.DPad)
    }
}