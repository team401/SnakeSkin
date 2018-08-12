package edu.wpi.first.wpilibj.hal

/**
 * @author Cameron Earle
 * @version 8/11/2018
 */
@Suppress("UNUSED_PARAMETER")
object ConstantsJNI: JNIWrapper() {
    @JvmStatic fun getSystemClockTicksPerMicrosecond(): Int {
        return 40
    }
}