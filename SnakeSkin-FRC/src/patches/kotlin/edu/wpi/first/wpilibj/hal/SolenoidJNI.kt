package edu.wpi.first.wpilibj.hal

import java.nio.ByteBuffer

/**
 * @author Cameron Earle
 * @version 8/11/2018
 */
@Suppress("UNUSED_PARAMETER")
object SolenoidJNI: JNIWrapper() {
    @JvmStatic fun initializeSolenoidPort(halPortHandle: Int): Int {
        return halPortHandle
    }

    @JvmStatic fun checkSolenoidModule(module: Int): Boolean {
        return true
    }

    @JvmStatic fun checkSolenoidChannel(channel: Int): Boolean {
        return true
    }

    @JvmStatic fun freeSolenoidPort(portHandle: Int) {}

    @JvmStatic fun setSolenoid(portHandle: Int, on: Boolean) {
        //val pm = ByteBuffer.allocate(2).putShort(portHandle.toShort()).array()
        //TODO set data in simulation env
        //pm[0] = port
        //pm[1] = module
    }

    @JvmStatic fun getSolenoid(portHandle: Int): Boolean {
        return false
        //TODO get data from simulation env
    }

    @JvmStatic fun getAllSolenoids(module: Int): Int {
        val buf = ByteBuffer.allocate(8)
        for (i in 0 until 8) {
            //TODO get data from simulation env
            buf.put(if (true) 1.toByte() else 0.toByte())
        }
        return buf.int
    }

    @JvmStatic fun getPCMSolenoidBlackList(module: Int): Int {
        return 0
    }

    @JvmStatic fun getPCMSolenoidVoltageStickyFault(module: Int): Boolean {
        return false
    }

    @JvmStatic fun getPCMSolenoidVoltageFault(module: Int): Boolean {
        return false
    }

    @JvmStatic fun clearAllPCMStickyFaults(module: Int) {}

    @JvmStatic fun setOneShotDuration(portHandle: Int, durationMS: Long) {
        //TODO possibly simulate this in the future
    }

    @JvmStatic fun fireOneShot(portHandle: Int) {
        //TODO possibly simulate this in the future
    }
}