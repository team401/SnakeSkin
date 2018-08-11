package edu.wpi.first.wpilibj.hal

/**
 * @author Cameron Earle
 * @version 8/11/2018
 */
object HALUtil: JNIWrapper() {
    @JvmStatic val NULL_PARAMETER = -1005
    @JvmStatic val SAMPLE_RATE_TOO_HIGH = 1001
    @JvmStatic val VOLTAGE_OUT_OF_RANGE = 1002
    @JvmStatic val LOOP_TIMING_ERROR = 1004
    @JvmStatic val INCOMPATIBLE_STATE = 1015
    @JvmStatic val ANALOG_TRIGGER_PULSE_OUTPUT_ERROR = -1011
    @JvmStatic val NO_AVAILABLE_RESOURCES = -104
    @JvmStatic val PARAMETER_OUT_OF_RANGE = -1028

    @JvmStatic fun getFPGAVersion(): Short {
        return 2009
    }

    @JvmStatic fun getFPGARevision(): Int {
        return 0
    }

    @JvmStatic fun getFPGATime(): Long {
        return System.nanoTime() / 1000 //TODO account for code startup time
    }

    @JvmStatic fun getHALRuntimeType(): Int {
        return 0
    }

    @JvmStatic fun getFPGAButton(): Boolean {
        return false //TODO add simulation environment
    }

    @JvmStatic fun getHALErrorMessage(code: Int): String {
        return ""
    }

    @JvmStatic fun getHALErrno(): Int {
        return 0
    }

    @JvmStatic fun getHALstrerror(errno: Int): String {
        return ""
    }

    @JvmStatic fun getHALstrerror(): String {
        return getHALstrerror(getHALErrno())
    }
}