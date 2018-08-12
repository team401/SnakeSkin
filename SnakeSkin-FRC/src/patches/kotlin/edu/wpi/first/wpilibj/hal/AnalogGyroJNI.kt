package edu.wpi.first.wpilibj.hal

/**
 * @author Cameron Earle
 * @version 8/11/2018
 */
object AnalogGyroJNI: JNIWrapper() {
    //TODO implement in sim env

    @JvmStatic fun initializeAnalogGyro(halAnalogInputHandle: Int): Int {
        return halAnalogInputHandle
    }

    @JvmStatic fun setupAnalogGyro(handle: Int) {}

    @JvmStatic fun freeAnalogGyro(handle: Int) {}

    @JvmStatic fun setAnalogGyroParameters(handle: Int,
                                         voltsPerDegreePerSecond: Double,
                                         offset: Double, center: Int) {

    }

    @JvmStatic fun setAnalogGyroVoltsPerDegreePerSecond(handle: Int,
                                                      voltsPerDegreePerSecond: Double) {

    }

    @JvmStatic fun resetAnalogGyro(handle: Int) {

    }

    @JvmStatic fun calibrateAnalogGyro(handle: Int) {

    }

    @JvmStatic fun setAnalogGyroDeadband(handle: Int, volts: Double) {

    }

    @JvmStatic fun getAnalogGyroAngle(handle: Int): Double {
        return 0.0
    }

    @JvmStatic fun getAnalogGyroRate(handle: Int): Double {
        return 0.0
    }

    @JvmStatic fun getAnalogGyroOffset(handle: Int): Double {
        return 0.0
    }

    @JvmStatic fun getAnalogGyroCenter(handle: Int): Int {
        return 0
    }
}