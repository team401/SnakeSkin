package edu.wpi.first.wpilibj.hal

import org.snakeskin.hardware.Hardware
import org.snakeskin.hardware.PCM
import java.nio.ByteBuffer

/**
 * @author Cameron Earle
 * @version 8/11/2018
 */
@Suppress("UNUSED_PARAMETER")
object SolenoidJNI: JNIWrapper() {
    @JvmStatic fun initializeSolenoidPort(halPortHandle: Int): Int {
        val pm = ByteBuffer.allocate(2).putShort(halPortHandle.toShort()).array()
        val module = pm[1]
        //Create a new PCM if it does not already exist
        if (!Hardware.hasHardware("pcm/$module", PCM::class.java)) {
            Hardware.addHardware("pcm/$module", PCM())
        }
        return halPortHandle
    }

    @JvmStatic fun checkSolenoidModule(module: Int): Boolean {
        if (module < 0) return false
        if (module > 63) return false
        return true
    }

    @JvmStatic fun checkSolenoidChannel(channel: Int): Boolean {
        if (channel < 0) return false
        if (channel > 7) return false
        return true
    }

    @JvmStatic fun freeSolenoidPort(portHandle: Int) {}

    @JvmStatic fun setSolenoid(portHandle: Int, on: Boolean) {
        val pm = ByteBuffer.allocate(2).putShort(portHandle.toShort()).array()
        val port = pm[0]
        val module = pm[1]

        try {
            val pcm = PCM.getFromHardwareRepository(module.toInt())
            pcm.getPort(port.toInt()).on = on
        } catch (e: Exception) {} //This could either be that the PCM doesn't exist or that the wrong type is in the hardware slot
        //Either way, we don't care, as these checks should have been made before we get here
    }

    @JvmStatic fun getSolenoid(portHandle: Int): Boolean {
        val pm = ByteBuffer.allocate(2).putShort(portHandle.toShort()).array()
        val port = pm[0]
        val module = pm[1]

        try {
            val pcm = PCM.getFromHardwareRepository(module.toInt())
            return pcm.getPort(port.toInt()).on
        } catch (e: Exception) {} //See above
        return false
    }

    @JvmStatic fun getAllSolenoids(module: Int): Int {
        val buf = ByteBuffer.allocate(8)
        try {
            val pcm = PCM.getFromHardwareRepository(module)
            for (i in 0 until 8) {
                val on = pcm.getPort(i).on
                buf.put(if (on) 1.toByte() else 0.toByte())
            }
        } catch (e: Exception) {}
        return buf.int
    }

    @JvmStatic fun getPCMSolenoidBlackList(module: Int): Int {
        val buf = ByteBuffer.allocate(8)
        try {
            val pcm = PCM.getFromHardwareRepository(module)
            for (i in 0 until 8) {
                val blacklisted = pcm.getPort(i).blacklisted
                buf.put(if (blacklisted) 1.toByte() else 0.toByte())
            }
        } catch (e: Exception) {}
        return buf.int
    }

    @JvmStatic fun getPCMSolenoidVoltageStickyFault(module: Int): Boolean {
        try {
            val pcm = PCM.getFromHardwareRepository(module)
            return pcm.voltageStickyFault
        } catch (e: Exception) {}
        return false
    }

    @JvmStatic fun getPCMSolenoidVoltageFault(module: Int): Boolean {
        try {
            val pcm = PCM.getFromHardwareRepository(module)
            return pcm.voltageFault
        } catch (e: Exception) {}
        return false
    }

    @JvmStatic fun clearAllPCMStickyFaults(module: Int) {
        try {
            val pcm = PCM.getFromHardwareRepository(module)
            pcm.voltageStickyFault = false
            //TODO check if we should clear other things here as well (channel blacklist)?
        } catch (e: Exception) {}
    }

    @JvmStatic fun setOneShotDuration(portHandle: Int, durationMS: Long) {
        val pm = ByteBuffer.allocate(2).putShort(portHandle.toShort()).array()
        val port = pm[0]
        val module = pm[1]
        try {
            val pcm = PCM.getFromHardwareRepository(module.toInt())
            pcm.getPort(port.toInt()).pulseDuration = durationMS
        } catch (e: Exception) {}
    }

    @JvmStatic fun fireOneShot(portHandle: Int) {
        //TODO possibly simulate this in the future
    }
}