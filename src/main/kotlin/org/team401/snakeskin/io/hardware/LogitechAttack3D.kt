package org.team401.snakeskin.io.hardware

import org.team401.snakeskin.io.InputDevice
import org.team401.snakeskin.io.Joystick
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
class LogitechAttack3D(dsPort: Int) : InputDevice(dsPort), Joystick {

    // TODO: check axis mappings

    override fun getYaw() = getAxis(0)

    override fun getPitch() = getAxis(1)

    override fun getRoll() = getAxis(2)

    override fun getThrottle() = getAxis(3).invert()

    override fun getTrigger() = getButtonValue(1)

    override fun getThumb() = getButtonValue(2)
}