package edu.wpi.first.wpilibj.hal

import org.snakeskin.hardware.RoboRIO

/**
 * @author Cameron Earle
 * @version 8/11/2018
 */
@Suppress("UNUSED_PARAMETER")
object AccelerometerJNI: JNIWrapper() {
    @JvmStatic fun setAccelerometerActive(active: Boolean) {}

    @JvmStatic fun setAccelerometerRange(range: Int) {}

    @JvmStatic fun getAccelerometerX(): Double {
        val rio = RoboRIO.getFromHardwareRepository()
        return rio.accelerometerX
    }

    @JvmStatic fun getAccelerometerY(): Double {
        val rio = RoboRIO.getFromHardwareRepository()
        return rio.accelerometerY
    }

    @JvmStatic fun getAccelerometerZ(): Double {
        val rio = RoboRIO.getFromHardwareRepository()
        return rio.accelerometerZ
    }
}