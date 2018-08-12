package edu.wpi.first.wpilibj.hal

/**
 * @author Cameron Earle
 * @version 8/11/2018
 */
@Suppress("UNUSED_PARAMETER")
object RelayJNI: JNIWrapper() {
    @JvmStatic fun initializeRelayPort(halPortHandle: Int, forward: Boolean): Int {
        return halPortHandle
    }

    @JvmStatic fun freeRelayPort(relayPortHandle: Int) {}

    @JvmStatic fun checkRelayChannel(channel: Int): Boolean {
        return true
    }

    @JvmStatic fun setRelay(relayPortHandle: Int, on: Boolean) {

    }

    @JvmStatic fun getRelay(relayPortHandle: Int): Boolean {
        return false
    }
}