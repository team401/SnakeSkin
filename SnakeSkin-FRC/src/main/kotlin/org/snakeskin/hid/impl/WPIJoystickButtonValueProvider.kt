package org.snakeskin.hid.impl

import edu.wpi.first.wpilibj.Joystick
import org.snakeskin.hid.provider.IButtonValueProvider

class WPIJoystickButtonValueProvider(val joystick: Joystick, val id: Int): IButtonValueProvider {
    override fun read(): Boolean {
        return joystick.getRawButton(id)
    }
}