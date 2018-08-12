package edu.wpi.first.wpilibj.hal

import java.nio.ByteBuffer

/**
 * @author Cameron Earle
 * @version 8/11/2018
 */
object SPIJNI: JNIWrapper() {
    @JvmStatic fun spiInitialize(port: Int) {

    }

    @JvmStatic fun spiTransaction(port: Int, dataToSend: ByteBuffer,
                                dataReceived: ByteBuffer, size: Byte): Int {
        return 0
    }

    @JvmStatic fun spiTransactionB(port: Int, dataToSend: ByteArray,
                                 dataReceived: ByteArray, size: Byte): Int {
        return 0
    }

    @JvmStatic fun spiWrite(port: Int, dataToSend: ByteBuffer, sendSize: Byte): Int {
        return 0
    }

    @JvmStatic fun spiWriteB(port: Int, dataToSend: ByteArray, sendSize: Byte): Int {
        return 0
    }

    @JvmStatic fun spiRead(port: Int, initiate: Boolean, dataReceived: ByteBuffer, size: Byte): Int {
        return 0
    }

    @JvmStatic fun spiReadB(port: Int, initiate: Boolean, dataReceived: ByteArray, size: Byte): Int {
        return 0
    }

    @JvmStatic fun spiClose(port: Int) {}

    @JvmStatic fun spiSetSpeed(port: Int, speed: Int) {

    }

    @JvmStatic fun spiSetOpts(port: Int, msbFirst: Int, sampleOnTrailing: Int,
                            clkIdleHigh: Int) {

    }

    @JvmStatic fun spiSetChipSelectActiveHigh(port: Int) {

    }

    @JvmStatic fun spiSetChipSelectActiveLow(port: Int) {

    }

    @JvmStatic fun spiInitAuto(port: Int, bufferSize: Int) {

    }

    @JvmStatic fun spiFreeAuto(port: Int) {

    }

    @JvmStatic fun spiStartAutoRate(port: Int, period: Double) {

    }

    @JvmStatic fun spiStartAutoTrigger(port: Int, digitalSourceHandle: Int,
                                     analogTriggerType: Int, triggerRising: Boolean,
                                     triggerFalling: Boolean) {

    }

    @JvmStatic fun spiStopAuto(port: Int) {

    }

    @JvmStatic fun spiSetAutoTransmitData(port: Int, dataToSend: ByteArray, zeroSize: Int) {

    }

    @JvmStatic fun spiForceAutoRead(port: Int) {

    }

    @JvmStatic fun spiReadAutoReceivedData(port: Int, buffer: ByteBuffer, numToRead: Int,
                                         timeout: Double): Int {
        return 0
    }

    @JvmStatic fun spiReadAutoReceivedData(port: Int, buffer: ByteArray, numToRead: Int,
                                         timeout: Double): Int {
        return 0
    }

    @JvmStatic fun spiGetAutoDroppedCount(port: Int): Int {
        return 0
    }
}