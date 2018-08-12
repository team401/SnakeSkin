package edu.wpi.first.wpilibj.hal

/**
 * @author Cameron Earle
 * @version 8/11/2018
 */
object InterruptJNI: JNIWrapper() {
    val HalInvalidHandle = 0

    interface InterruptJNIHandlerFunction {
        fun apply(interruptAssertedMask: Int, param: Any)
    }

    @JvmStatic fun initializeInterrupts(watcher: Boolean): Int {
        return 0
    }

    @JvmStatic fun cleanInterrupts(interruptHandle: Int) {}

    @JvmStatic fun waitForInterrupt(interruptHandle: Int, timeout: Double,
                                  ignorePrevious: Boolean): Int {
        return 0
    }

    @JvmStatic fun enableInterrupts(interruptHandle: Int) {}

    @JvmStatic fun disableInterrupts(interruptHandle: Int) {}

    @JvmStatic fun readInterruptRisingTimestamp(interruptHandle: Int): Double {
        return 0.0
    }

    @JvmStatic fun readInterruptFallingTimestamp(interruptHandle: Int): Double {
        return 0.0
    }

    @JvmStatic fun requestInterrupts(interruptHandle: Int, digitalSourceHandle: Int,
                                   analogTriggerType: Int) {

    }

    @JvmStatic fun attachInterruptHandler(interruptHandle: Int,
                                        handler: InterruptJNIHandlerFunction,
                                        param: Any) {

    }

    @JvmStatic fun setInterruptUpSourceEdge(interruptHandle: Int, risingEdge: Boolean,
                                          fallingEdge: Boolean) {

    }
}