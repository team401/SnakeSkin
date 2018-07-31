package org.snakeskin.controls.impl

import edu.wpi.first.wpilibj.Joystick
import org.snakeskin.controls.ControllerProvider

/**
 * @author Cameron Earle
 * @version 7/30/2018
 *
 */
class HardwareControllerProvider(private val joystick: Joystick): ControllerProvider {
    override fun readAxis(id: Int): Double {
        return joystick.getRawAxis(id)
    }

    override fun readButton(id: Int): Boolean {
        return joystick.getRawButton(id)
    }

    override fun readHat(id: Int): Int {
        return joystick.getPOV(id)
    }
}