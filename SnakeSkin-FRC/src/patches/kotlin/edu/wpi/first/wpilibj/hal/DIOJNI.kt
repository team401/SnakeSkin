package edu.wpi.first.wpilibj.hal

/**
 * @author Cameron Earle
 * @version 8/11/2018
 */
@Suppress("UNUSED_PARAMETER")
object DIOJNI: JNIWrapper() {
    @JvmStatic fun initializeDIOPort(halPortHandle: Int, input: Boolean): Int {
        return halPortHandle
    }

    @JvmStatic fun checkDIOChannel(channel: Int): Boolean {
        return true
    }

    @JvmStatic fun freeDIOPort(dioPortHandle: Int) {}

    @JvmStatic fun setDIO(dioPortHandle: Int, value: Short) {

    }

    @JvmStatic fun getDIO(dioPortHandle: Int): Boolean {
        return false
    }

    @JvmStatic fun getDIODirection(dioPortHandle: Int): Boolean {
        return false
    }

    @JvmStatic fun pulse(dioPortHandle: Int, pulseLength: Double) {

    }

    @JvmStatic fun isPulsing(dioPortHandle: Int): Boolean {
        return false
    }

    @JvmStatic fun isAnyPulsing(): Boolean {
        return false
    }

    @JvmStatic fun getLoopTiming(): Short {
        return 80
    }

    @JvmStatic fun allocateDigitalPWM(): Int {
        return 0
    }

    @JvmStatic fun freeDigitalPWM(pwmGenerator: Int) {}

    @JvmStatic fun setDigitalPWMRate(rate: Double) {

    }

    @JvmStatic fun setDigitalPWMDutyCycle(pwmGenerator: Int, dutyCycle: Double) {

    }

    @JvmStatic fun setDigitalPWMOutputChannel(pwmGenerator: Int, channel: Int) {

    }
}