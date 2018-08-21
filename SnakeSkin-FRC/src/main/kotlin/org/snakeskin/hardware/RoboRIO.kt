package org.snakeskin.hardware

import org.snakeskin.logic.LockingDelegate

/**
 * @author Cameron Earle
 * @version 8/12/18
 *
 * Represents the RoboRIO, and all of the corresponding properties that go with it
 * Note that this does not contain any IO, but instead things like system voltage, built in accelerometer, user button, etc.
 */
class RoboRIO: IHardware {
    companion object {
        fun getFromHardwareRepository(): RoboRIO {
            return Hardware.getHardware("roborio") as RoboRIO
        }
    }

    /**
     * Represents the built-in accelerometer X value
     * Unit is in G forces
     */
    var accelerometerX by LockingDelegate(0.0)

    /**
     * Represents the built-in accelerometer Y value
     * Unit is in G forces
     */
    var accelerometerY by LockingDelegate(0.0)

    /**
     * Represents the built-in accelerometer Z value
     * Unit is in G forces
     */
    var accelerometerZ by LockingDelegate(0.0)


}