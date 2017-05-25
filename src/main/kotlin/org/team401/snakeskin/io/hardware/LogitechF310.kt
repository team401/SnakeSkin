package org.team401.snakeskin.io.hardware

import edu.wpi.first.wpilibj.GenericHID
import org.team401.snakeskin.io.InputDevice
import org.team401.snakeskin.io.RumbleGamepad
import org.team401.snakeskin.logic.Axis

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
class LogitechF310(dsPort: Int) : InputDevice(dsPort), RumbleGamepad {

    override fun getLeftX() = getAxis(0)

    override fun getLeftY() = getAxis(1) scale Axis.INVERTED

    override fun getRightX() = getAxis(4)

    override fun getRightY() = getAxis(5) scale Axis.INVERTED

    override fun getLeftTrigger() = getAxis(2)

    override fun getRightTrigger() = getAxis(3)

    override fun getA() = getButtonValue(0)

    override fun getB() = getButtonValue(1)

    override fun getX() = getButtonValue(2)

    override fun getY() = getButtonValue(3)

    override fun getLeftBumper() = getButtonValue(4)

    override fun getRightBumper() = getButtonValue(5)

    override fun getLeftStick() = getButtonValue(8)

    override fun getRightStick() = getButtonValue(9)

    override fun getStart() = getButtonValue(7)

    override fun getSelect() = getButtonValue(6)

    override fun getDPad() = getDPadValue(0)

    override fun setLeftRumble(intensity: Double) = input.setRumble(GenericHID.RumbleType.kLeftRumble, intensity)

    override fun setRightRumble(intensity: Double) = input.setRumble(GenericHID.RumbleType.kRightRumble, intensity)
}