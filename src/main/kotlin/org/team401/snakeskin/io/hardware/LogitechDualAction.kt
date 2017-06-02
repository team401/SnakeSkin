package org.team401.snakeskin.io.hardware

import org.team401.snakeskin.io.Gamepad
import org.team401.snakeskin.io.InputDevice
import org.team401.snakeskin.logic.Axis
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
class LogitechDualAction(dsPort: Int) : InputDevice(dsPort), Gamepad {

    override fun getLeftX() = getAxis(0)

    override fun getLeftY() = getAxis(1).invert()

    override fun getRightX() = getAxis(4)

    override fun getRightY() = getAxis(5).invert()

    override fun getLeftTrigger() = Axis { if (getButtonValue(6).isTriggered()) 1.0 else 0.0}

    override fun getRightTrigger() = Axis { if (getButtonValue(7).isTriggered()) 1.0 else 0.0}

    override fun getA() = getButtonValue(1)

    override fun getB() = getButtonValue(2)

    override fun getX() = getButtonValue(0)

    override fun getY() = getButtonValue(3)

    override fun getLeftBumper() = getButtonValue(4)

    override fun getRightBumper() = getButtonValue(5)

    override fun getLeftStick() = getButtonValue(10)

    override fun getRightStick() = getButtonValue(11)

    override fun getStart() = getButtonValue(9)

    override fun getSelect() = getButtonValue(8)

    override fun getDPad() = getDPadValue(0)

}