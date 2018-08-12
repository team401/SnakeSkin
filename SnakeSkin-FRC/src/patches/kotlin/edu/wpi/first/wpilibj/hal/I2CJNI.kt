package edu.wpi.first.wpilibj.hal

import java.nio.ByteBuffer

/**
 * @author Cameron Earle
 * @version 8/11/2018
 */
object I2CJNI: JNIWrapper() {
    @JvmStatic fun i2CInitialize(port: Int) {}

    @JvmStatic fun i2CTransaction(port: Int, address: Byte, dataToSend: ByteBuffer,
                                sendSize: Byte, dataReceived: ByteBuffer, receiveSize: Byte): Int {
        return 0
    }

    @JvmStatic fun i2CTransactionB(port: Int, address: Byte, dataToSend: ByteArray,
                                 sendSize: Byte, dataReceived: ByteArray, receiveSize: Byte): Int {
        return 0
    }

    @JvmStatic fun i2CWrite(port: Int, address: Byte, dataToSend: ByteBuffer, sendSize: Byte): Int {
        return 0
    }

    @JvmStatic fun i2CWriteB(port: Int, address: Byte, dataToSend: ByteArray, sendSize: Byte): Int {
        return 0
    }

    @JvmStatic fun i2CRead(port: Int, address: Byte, dataReceived: ByteBuffer,
                         receiveSize: Byte): Int {
        return 0
    }

    @JvmStatic fun i2CReadB(port: Int, address: Byte, dataReceived: ByteArray,
                          receiveSize: Byte): Int {
        return 0
    }

    @JvmStatic fun i2CClose(port: Int) {}
}