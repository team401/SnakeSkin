package edu.wpi.first.wpilibj.hal

/**
 * @author Cameron Earle
 * @version 8/11/2018
 */
@Suppress("UNUSED_PARAMETER")
object SerialPortJNI: JNIWrapper() {
    @JvmStatic fun serialInitializePort(port: Byte) {

    }

    @JvmStatic fun serialSetBaudRate(port: Byte, baud: Int) {

    }

    @JvmStatic fun serialSetDataBits(port: Byte, bits: Byte) {

    }

    @JvmStatic fun serialSetParity(port: Byte, parity: Byte) {

    }

    @JvmStatic fun serialSetStopBits(port: Byte, stopBits: Byte) {

    }

    @JvmStatic fun serialSetWriteMode(port: Byte, mode: Byte) {

    }

    @JvmStatic fun serialSetFlowControl(port: Byte, flow: Byte) {

    }

    @JvmStatic fun serialSetTimeout(port: Byte, timeout: Double) {

    }

    @JvmStatic fun serialEnableTermination(port: Byte, terminator: Char) {

    }

    @JvmStatic fun serialDisableTermination(port: Byte) {

    }

    @JvmStatic fun serialSetReadBufferSize(port: Byte, size: Int) {

    }

    @JvmStatic fun serialSetWriteBufferSize(port: Byte, size: Int) {

    }

    @JvmStatic fun serialGetBytesReceived(port: Byte): Int {
        return 0
    }

    @JvmStatic fun serialRead(port: Byte, buffer: ByteArray, count: Int): Int {
        return 0
    }

    @JvmStatic fun serialWrite(port: Byte, buffer: ByteArray, count: Int): Int {
        return 0
    }

    @JvmStatic fun serialFlush(port: Byte) {

    }

    @JvmStatic fun serialClear(port: Byte) {

    }

    @JvmStatic fun serialClose(port: Byte) {

    }
}