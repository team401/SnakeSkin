package org.snakeskin.hid.impl

import edu.wpi.first.wpilibj.Joystick
import org.snakeskin.hid.provider.IAxisValueProvider

class WPIJoystickAxisValueProvider(val joystick: Joystick, val id: Int): IAxisValueProvider {
    override fun read(): Double {
        return joystick.getRawAxis(id)
    }
}