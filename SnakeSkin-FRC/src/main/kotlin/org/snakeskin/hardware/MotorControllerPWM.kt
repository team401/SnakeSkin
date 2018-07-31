package org.snakeskin.hardware

import edu.wpi.first.wpilibj.PWMSpeedController
import org.snakeskin.ability.AInvertable

/**
 * @author Cameron Earle
 * @version 7/31/18
 */
interface MotorControllerPWM: IHardware<PWMSpeedController>, AInvertable {
    fun get(): Double
    fun set(value: Double)

    fun disable()
    fun stopMotor()

    var isSafetyEnabled: Boolean
    var expiration: Double
    fun feed()
    val isAlive: Boolean
}