package org.team401.snakeskin.io

import edu.wpi.first.wpilibj.Joystick
import org.team401.snakeskin.logic.DirectionalAxis
import org.team401.snakeskin.logic.Range
import org.team401.snakeskin.logic.Switch

/*
 * SnakeSkin - Created on 5/24/17
 * Author: Zachary Kozar
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at the project root.
 */

/**
 * @author Zachary Kozar
 * @version 5/24/17
 */
abstract class InputDevice(dsPort: Int) {

    internal val input = Joystick(dsPort)

    fun getAxis(axis: Int) = object : Range {
        override fun read() = input.getRawAxis(axis)
    }

    fun getButtonValue(button: Int) = object : Switch {
        override fun isTriggered() = input.getRawButton(button)
    }

    fun getDPadValue(dpad: Int) = object : DirectionalAxis {
        override fun getDirection() = input.getPOV(dpad)
    }
}