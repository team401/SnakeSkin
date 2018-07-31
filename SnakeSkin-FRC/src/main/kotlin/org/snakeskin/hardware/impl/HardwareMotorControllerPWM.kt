package org.snakeskin.hardware.impl

import edu.wpi.first.wpilibj.PWMSpeedController
import org.snakeskin.hardware.MotorControllerPWM

/**
 * @author Cameron Earle
 * @version 7/31/18
 */
class HardwareMotorControllerPWM(override val hardwareObj: PWMSpeedController): MotorControllerPWM {
    override fun get(): Double {
        return hardwareObj.get()
    }

    override fun set(value: Double) {
        hardwareObj.set(value)
    }

    override fun disable() {
        hardwareObj.disable()
    }

    override fun stopMotor() {
        hardwareObj.stopMotor()
    }

    override var expiration: Double
        get() = hardwareObj.expiration
        set(value) {hardwareObj.expiration = value}

    override val isAlive: Boolean
        get() = hardwareObj.isAlive

    override var isSafetyEnabled: Boolean
        get() = hardwareObj.isSafetyEnabled
        set(value) {hardwareObj.isSafetyEnabled = value}

    override var inverted: Boolean
        get() = hardwareObj.inverted
        set(value) {hardwareObj.inverted = value}

    override fun feed() {
        hardwareObj.feed()
    }
}