package edu.wpi.first.wpilibj.hal

import java.nio.ByteBuffer

/**
 * @author Cameron Earle
 * @version 8/11/2018
 */
open class JNIWrapper {
    companion object {
        @JvmStatic fun getPortWithModule(module: Byte, channel: Byte): Int {
            val data = byteArrayOf(module, channel)
            return ByteBuffer.wrap(data).short.toInt()
        }

        @JvmStatic fun getPort(channel: Byte): Int {
            return getPortWithModule(0.toByte(), channel)
        }
    }
}