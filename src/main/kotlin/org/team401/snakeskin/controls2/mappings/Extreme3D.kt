package org.team401.snakeskin.controls2.mappings

import org.team401.snakeskin.controls2.Controller

/*
 * snakeskin - Created on 7/16/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 7/16/17
 */
class Extreme3D(id: Int): Controller(id) {
    inner class AxesDefinitions: Controller.AxesDefinitions {
        val YAW = addHardwareAxis(HardwareAxis(0))
        val PITCH = addHardwareAxis(HardwareAxis(1))
        val ROLL = addHardwareAxis(HardwareAxis(2))
        val THROTTLE = addHardwareAxis(HardwareAxis(3, true))
    }
    override val Axes = AxesDefinitions()

    inner class ButtonsDefinitions: Controller.ButtonsDefinitions {
        val TRIGGER = addHardwareButton(HardwareButton(0))
        val THUMB = addHardwareButton(HardwareButton(1))
        val STICK_BOTTOM_LEFT = addHardwareButton(HardwareButton(2))
        val STICK_BOTTOM_RIGHT = addHardwareButton(HardwareButton(3))
        val STICK_TOP_LEFT = addHardwareButton(HardwareButton(4))
        val STICK_TOP_RIGHT = addHardwareButton(HardwareButton(5))
        val BASE_TOP_LEFT = addHardwareButton(HardwareButton(6))
        val BASE_TOP_RIGHT = addHardwareButton(HardwareButton(7))
        val BASE_MIDDLE_LEFT = addHardwareButton(HardwareButton(8))
        val BASE_MIDDLE_RIGHT = addHardwareButton(HardwareButton(9))
        val BASE_BOTTOM_LEFT = addHardwareButton(HardwareButton(10))
        val BASE_BOTTOM_RIGHT = addHardwareButton(HardwareButton(11))
    }
    override val Buttons = ButtonsDefinitions()

    inner class HatsDefinitions: Controller.HatsDefinitions {
        val STICK_HAT = addHardwareHat(HardwareHat(0))
    }
    override val Hats = HatsDefinitions()
}