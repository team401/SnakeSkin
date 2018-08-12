package edu.wpi.first.wpilibj.hal

/**
 * @author Cameron Earle
 * @version 8/11/2018
 */
@Suppress("UNUSED_PARAMETER")
object AccelerometerJNI: JNIWrapper() {
    //TODO implement in sim env

    @JvmStatic fun setAccelerometerActive(active: Boolean) {

    }

    @JvmStatic fun setAccelerometerRange(range: Int) {

    }

    @JvmStatic fun getAccelerometerX(): Double {
        return 0.0
    }

    @JvmStatic fun getAccelerometerY(): Double {
        return 0.0
    }

    @JvmStatic fun getAccelerometerZ(): Double {
        return 0.0
    }
}