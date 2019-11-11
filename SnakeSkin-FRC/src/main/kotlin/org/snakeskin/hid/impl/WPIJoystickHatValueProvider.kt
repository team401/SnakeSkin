package org.snakeskin.hid.impl

import edu.wpi.first.wpilibj.Joystick
import org.snakeskin.hid.provider.IHatValueProvider

class WPIJoystickHatValueProvider(val joystick: Joystick, val id: Int): IHatValueProvider {
    override fun read(): Int {
        return joystick.getPOV(id)
    }
}