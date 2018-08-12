package edu.wpi.first.wpilibj.hal

/**
 * @author Cameron Earle
 * @version 8/11/2018
 */
object PDPJNI: JNIWrapper() {
    @JvmStatic fun initializePDP(module: Int) {

    }

    @JvmStatic fun checkPDPModule(module: Int): Boolean {
        return true
    }

    @JvmStatic fun checkPDPChannel(channel: Int): Boolean {
        return true
    }

    @JvmStatic fun getPDPTemperature(module: Int): Double {
        return 0.0
    }

    @JvmStatic fun getPDPVoltage(module: Int): Double {
        return 12.0
    }

    @JvmStatic fun getPDPChannelCurrent(channel: Byte, module: Int): Double {
        return 0.0
    }

    @JvmStatic fun getPDPTotalCurrent(module: Int): Double {
        return 0.0
    }

    @JvmStatic fun getPDPTotalPower(module: Int): Double {
        return 0.0
    }

    @JvmStatic fun getPDPTotalEnergy(module: Int): Double {
        return 0.0
    }

    @JvmStatic fun resetPDPTotalEnergy(module: Int) {

    }

    @JvmStatic fun clearPDPStickyFaults(module: Int) {

    }
}