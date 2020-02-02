package org.snakeskin.hid.impl

import edu.wpi.first.wpilibj.Joystick
import org.snakeskin.hid.IHIDValueProviderFactory
import org.snakeskin.hid.provider.IAxisValueProvider
import org.snakeskin.hid.provider.IButtonValueProvider
import org.snakeskin.hid.provider.IHatValueProvider

class ControlSurfaceProviderFactoryWpi(private val joystick: Joystick): IHIDValueProviderFactory {
    override fun createAxisValueProvider(id: Int): IAxisValueProvider {
        return WPIJoystickAxisValueProvider(joystick, id)
    }

    override fun createButtonValueProvider(id: Int): IButtonValueProvider {
        return WPIJoystickButtonValueProvider(joystick, id)
    }

    override fun createHatValueProvider(id: Int): IHatValueProvider {
        return WPIJoystickHatValueProvider(joystick, id)
    }
}