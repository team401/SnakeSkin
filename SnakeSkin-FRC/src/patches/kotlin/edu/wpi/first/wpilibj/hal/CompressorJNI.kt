package edu.wpi.first.wpilibj.hal

/**
 * @author Cameron Earle
 * @version 8/11/2018
 */
object CompressorJNI: JNIWrapper() {
    @JvmStatic fun initializeCompressor(module: Byte): Int {
        return module.toInt()
    }

    @JvmStatic fun checkCompressorModule(module: Byte): Boolean {
        return true
    }

    @JvmStatic fun getCompressor(compressorHandle: Int): Boolean {
        return false
    }

    @JvmStatic fun setCompressorClosedLoopControl(compressorHandle: Int, value: Boolean) {

    }

    @JvmStatic fun getCompressorClosedLoopControl(compressorHandle: Int): Boolean {
        return false
    }

    @JvmStatic fun getCompressorPressureSwitch(compressorHandle: Int): Boolean {
        return false
    }

    @JvmStatic fun getCompressorCurrent(compressorHandle: Int): Double {
        return 0.0
    }

    @JvmStatic fun getCompressorCurrentTooHighFault(compressorHandle: Int): Boolean {
        return false
    }

    @JvmStatic fun getCompressorCurrentTooHighStickyFault(compressorHandle: Int): Boolean {
        return false
    }

    @JvmStatic fun getCompressorShortedStickyFault(compressorHandle: Int): Boolean {
        return false
    }

    @JvmStatic fun getCompressorShortedFault(compressorHandle: Int): Boolean {
        return false
    }

    @JvmStatic fun getCompressorNotConnectedStickyFault(compressorHandle: Int): Boolean {
        return false
    }

    @JvmStatic fun getCompressorNotConnectedFault(compressorHandle: Int): Boolean {
        return false
    }

    @JvmStatic fun clearAllPCMStickyFaults(compressorModule: Byte) {

    }
}