package org.snakeskin.hid.mappings

import org.snakeskin.hid.HIDController

/**
 * @author Cameron Earle
 * @version 8/31/17
 */
class Attack3(id: Int): HIDController(id) {
    object Axes {
        const val Roll = 0
        const val Pitch = 1
        const val Throttle = 2
    }

    object Buttons {
        const val Trigger = 1
        const val StickBottom = 2
        const val StickTop = 3
        const val StickLeft = 4
        const val StickRight = 5
        const val BaseLeftTop = 6
        const val BaseLeftBottom = 7
        const val BaseBottomLeft = 8
        const val BaseBottomRight = 9
        const val BaseRightBottom = 10
        const val BaseRightTop = 11
    }

    init {
        addAxis(Axes.Roll)
        addAxis(Axes.Pitch)
        addAxis(Axes.Throttle, true)

        addButton(Buttons.Trigger)
        addButton(Buttons.StickBottom)
        addButton(Buttons.StickTop)
        addButton(Buttons.StickLeft)
        addButton(Buttons.StickRight)
        addButton(Buttons.BaseLeftTop)
        addButton(Buttons.BaseLeftBottom)
        addButton(Buttons.BaseBottomLeft)
        addButton(Buttons.BaseBottomRight)
        addButton(Buttons.BaseRightBottom)
        addButton(Buttons.BaseRightTop)
    }
}