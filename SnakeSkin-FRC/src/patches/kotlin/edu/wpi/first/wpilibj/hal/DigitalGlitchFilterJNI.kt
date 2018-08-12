package edu.wpi.first.wpilibj.hal

/**
 * @author Cameron Earle
 * @version 8/11/2018
 */
@Suppress("UNUSED_PARAMETER")
object DigitalGlitchFilterJNI: JNIWrapper() {
    @JvmStatic fun setFilterSelect(digitalPortHandle: Int, filterIndex: Int) {

    }

    @JvmStatic fun getFilterSelect(digitalPortHandle: Int): Int {
        return 0
    }

    @JvmStatic fun setFilterPeriod(filterIndex: Int, fpgaCycles: Int) {

    }

    @JvmStatic fun getFilterPeriod(filterIndex: Int): Int {
        return 1
    }
}