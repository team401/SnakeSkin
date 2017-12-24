package org.snakeskin.component

import edu.wpi.first.wpilibj.SpeedController

/*
 * snakeskin - Created on 7/21/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 7/21/17
 */
class MotorGroup<T: SpeedController>(private vararg val motors: T): Component, SpeedController {
    override fun setInverted(isInverted: Boolean) = motors.forEach {
        it.inverted = isInverted
    }

    override fun getInverted() = motors.all { it.inverted }

    override fun pidWrite(output: Double) = motors.forEach {
        it.pidWrite(output)
    }

    override fun stopMotor() = motors.forEach {
        it.stopMotor()
    }

    override fun get(): Double {
        if (motors.isNotEmpty()) {
            var sum = 0.0
            motors.forEach {
                sum += it.get()
            }
            return sum / motors.size
        } else {
            return 0.0
        }
    }

    override fun set(speed: Double) = motors.forEach {
        it.set(speed)
    }

    override fun disable() = motors.forEach {
        it.disable()
    }

}