package edu.wpi.first.wpilibj.hal

import edu.wpi.first.wpilibj.PWMConfigDataResult

/**
 * @author Cameron Earle
 * @version 8/11/2018
 */
object PWMJNI: JNIWrapper() {
    @JvmStatic fun initializePWMPort(halPortHandle: Int): Int {
        return halPortHandle
    }

    @JvmStatic fun checkPWMChannel(channel: Int): Boolean {
        return true
    }

    @JvmStatic fun freePWMPort(pwmPortHandle: Int) {}

    @JvmStatic fun setPWMConfigRaw(pwmPortHandle: Int, maxPwm: Int,
                                 deadbandMaxPwm: Int, centerPwm: Int,
                                 deadbandMinPwm: Int, minPwm: Int) {

    }

    @JvmStatic fun setPWMConfig(pwmPortHandle: Int, maxPwm: Double,
                              deadbandMaxPwm: Double, centerPwm: Double,
                              deadbandMinPwm: Double, minPwm: Double) {

    }

    @JvmStatic fun getPWMConfigRaw(pwmPortHandle: Int): PWMConfigDataResult {
        val constructor = PWMConfigDataResult::class.java.getDeclaredConstructor(
                Int::class.java,
                Int::class.java,
                Int::class.java,
                Int::class.java,
                Int::class.java
        )

        constructor.isAccessible = true
        return constructor.newInstance(0, 0, 0, 0, 0)
    }

    @JvmStatic fun setPWMEliminateDeadband(pwmPortHandle: Int, eliminateDeadband: Boolean) {

    }

    @JvmStatic fun getPWMEliminateDeadband(pwmPortHandle: Int): Boolean {
        return false
    }

    @JvmStatic fun setPWMRaw(pwmPortHandle: Int, value: Short) {

    }

    @JvmStatic fun setPWMSpeed(pwmPortHandle: Int, speed: Double) {

    }

    @JvmStatic fun setPWMPosition(pwmPortHandle: Int, position: Double) {

    }

    @JvmStatic fun getPWMRaw(pwmPortHandle: Int): Short {
        return 0
    }

    @JvmStatic fun getPWMSpeed(pwmPortHandle: Int): Double {
        return 0.0
    }

    @JvmStatic fun getPWMPosition(pwmPortHandle: Int): Double {
        return 0.0
    }

    @JvmStatic fun setPWMDisabled(pwmPortHandle: Int) {

    }

    @JvmStatic fun latchPWMZero(pwmPortHandle: Int) {

    }

    @JvmStatic fun setPWMPeriodScale(pwmPortHandle: Int, squelchMask: Int) {

    }
}