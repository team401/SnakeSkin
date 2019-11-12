package org.snakeskin.hid.mappings

import org.snakeskin.hid.HIDController

/**
 * @author Cameron Earle
 * @version 1/4/18
 */
class T16000M(id: Int): HIDController(id) {
    object Axes {
        const val Roll = 0
        const val Pitch = 1
        const val Yaw = 2
        const val Throttle = 3
    }

    object Buttons {
        const val Trigger = 1
        const val StickBottom = 2
        const val StickLeft = 3
        const val StickRight = 4
        const val BaseLeftTop1 = 5
        const val BaseLeftTop2 = 6
        const val BaseLeftTop3 = 7
        const val BaseLeftBottom3 = 8
        const val BaseLeftBottom2 = 9
        const val BaseLeftBottom1 = 10
        const val BaseRightTop3 = 11
        const val BaseRightTop2 = 12
        const val BaseRightTop1 = 13
        const val BaseRightBottom1 = 14
        const val BaseRightBottom2 = 15
        const val BaseRightBottom3 = 16
    }

    object Hats {
        const val StickHat = 0
    }

    init {
        addAxis(Axes.Roll)
        addAxis(Axes.Pitch)
        addAxis(Axes.Yaw)
        addAxis(Axes.Throttle, true)

        addButton(Buttons.Trigger)
        addButton(Buttons.StickBottom)
        addButton(Buttons.StickLeft)
        addButton(Buttons.StickRight)
        addButton(Buttons.BaseLeftTop1)
        addButton(Buttons.BaseLeftTop2)
        addButton(Buttons.BaseLeftTop3)
        addButton(Buttons.BaseLeftBottom3)
        addButton(Buttons.BaseLeftBottom2)
        addButton(Buttons.BaseLeftBottom1)
        addButton(Buttons.BaseRightTop3)
        addButton(Buttons.BaseRightTop2)
        addButton(Buttons.BaseRightTop1)
        addButton(Buttons.BaseRightBottom1)
        addButton(Buttons.BaseRightBottom2)
        addButton(Buttons.BaseRightBottom3)

        addHat(Hats.StickHat)
    }
}