package edu.wpi.first.wpilibj.hal

/**
 * @author Cameron Earle
 * @version 8/11/2018
 */
object PowerJNI {
    @JvmStatic fun getVinVoltage(): Double {
        return 12.0
    }

    @JvmStatic fun getVinCurrent(): Double {
        return 0.0
    }

    @JvmStatic fun getUserVoltage6V(): Double {
        return 6.0
    }

    @JvmStatic fun getUserCurrent6V(): Double {
        return 0.0
    }

    @JvmStatic fun getUserActive6V(): Boolean {
        return true
    }

    @JvmStatic fun getUserCurrentFaults6V(): Int {
        return 0
    }

    @JvmStatic fun getUserVoltage5V(): Double {
        return 5.0
    }

    @JvmStatic fun getUserCurrent5V(): Double {
        return 0.0
    }

    @JvmStatic fun getUserActive5V(): Boolean {
        return true
    }

    @JvmStatic fun getUserCurrentFaults5V(): Int {
        return 0
    }

    @JvmStatic fun getUserVoltage3V3(): Double {
        return 3.3
    }

    @JvmStatic fun getUserCurrent3V3(): Double {
        return 0.0
    }

    @JvmStatic fun getUserActive3V3(): Boolean {
        return true
    }

    @JvmStatic fun getUserCurrentFaults3V3(): Int {
        return 0
    }
}