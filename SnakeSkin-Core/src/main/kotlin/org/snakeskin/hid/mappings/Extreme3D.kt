package org.snakeskin.hid.mappings

import org.snakeskin.hid.HIDController

/**
 * @author Cameron Earle
 * @version 7/16/17
 */
class Extreme3D(id: Int): HIDController(id) {
    object Axes {
        const val Yaw = 0
        const val Pitch = 1
        const val Roll = 2
        const val Throttle = 3
    }

    object Buttons {
        const val Trigger = 1
        const val Thumb = 2
        const val StickBottomLeft = 3
        const val StickBottomRight = 4
        const val StickTopLeft = 5
        const val StickTopRight = 6
        const val BaseTopLeft = 7
        const val BaseTopRight = 8
        const val BaseMiddleLeft = 9
        const val BaseMiddleRight = 10
        const val BaseBottomLeft = 11
        const val BaseBottomRight = 12
    }

    object Hats {
        const val StickHat = 0
    }

    init {
        addAxis(Axes.Yaw)
        addAxis(Axes.Pitch)
        addAxis(Axes.Roll)
        addAxis(Axes.Throttle, true)

        addButton(Buttons.Trigger)
        addButton(Buttons.Thumb)
        addButton(Buttons.StickBottomLeft)
        addButton(Buttons.StickBottomRight)
        addButton(Buttons.StickTopLeft)
        addButton(Buttons.StickTopRight)
        addButton(Buttons.BaseTopLeft)
        addButton(Buttons.BaseTopRight)
        addButton(Buttons.BaseMiddleLeft)
        addButton(Buttons.BaseMiddleRight)
        addButton(Buttons.BaseBottomLeft)
        addButton(Buttons.BaseBottomRight)

        addHat(Hats.StickHat)
    }
}