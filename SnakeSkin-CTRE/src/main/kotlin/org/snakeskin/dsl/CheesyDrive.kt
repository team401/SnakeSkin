package org.snakeskin.dsl

import com.ctre.phoenix.motorcontrol.ControlMode
import org.snakeskin.component.TankDrivetrain

/*
 * snakeskin - Created on 12/26/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 12/26/17
 */

/**
 * Implements the Cheesy Poofs "Cheesy Drive" for a SnakeSkin drivetrain
 */

data class CheesyDriveParameters(val highWheelNonLinearity: Double,
                                 val lowWheelNonLinearity: Double,
                                 val highNegInertiaScalar: Double,
                                 val lowNegInertiaThreshold: Double,
                                 val lowNegInertiaTurnScalar: Double,
                                 val lowNegInertiaCloseScalar: Double,
                                 val lowNegInertiaFarScalar: Double,
                                 val highSensitivity: Double,
                                 val lowSensitivity: Double,
                                 val quickStopDeadband: Double,
                                 val quickStopWeight: Double,
                                 val quickStopScalar: Double,
                                 val lowSinCount: Int,
                                 val highSinCount: Int,
                                 val outputScalar: Double = 1.0) {

    var oldWheel = 0.0
    var quickStopAccumulator = 0.0
    var negInertiaAccumulator = 0.0

    val highDenom = Math.sin(Math.PI / 2.0 * highWheelNonLinearity)
    val lowDenom = Math.sin(Math.PI / 2.0 * lowWheelNonLinearity)

    fun reset() {
        oldWheel = 0.0
        quickStopAccumulator = 0.0
        negInertiaAccumulator = 0.0
    }
}

fun TankDrivetrain.cheesy(mode: ControlMode, p: CheesyDriveParameters, throttleIn: Double, wheelIn: Double, quickTurn: Boolean = false) {
    var wheel = wheelIn
    var throttle = throttleIn

    val negInertia = wheel - p.oldWheel
    p.oldWheel = wheel

    if (isHigh()) {
        for (i in 0 until p.highSinCount) {
            wheel = Math.sin(Math.PI / 2.0 * p.highWheelNonLinearity * wheel) / p.highDenom
        }
    } else {
        for (i in 0 until p.lowSinCount) {
            wheel = Math.sin(Math.PI / 2.0 * p.lowWheelNonLinearity * wheel) / p.lowDenom
        }
    }

    var leftOut = 0.0
    var rightOut = 0.0
    var overPower = 0.0
    var sensitivity = 0.0
    var angularPower = 0.0
    var linearPower = 0.0
    var negInertiaScalar = 0.0

    if (isHigh()) {
        negInertiaScalar = p.highNegInertiaScalar
        sensitivity = p.highSensitivity
    } else {
        if (wheel * negInertia > 0) {
            negInertiaScalar = p.lowNegInertiaTurnScalar
        } else {
            if (Math.abs(wheel) > p.lowNegInertiaThreshold) {
                negInertiaScalar = p.lowNegInertiaFarScalar
            } else {
                negInertiaScalar = p.lowNegInertiaCloseScalar
            }
        }
        sensitivity = p.lowSensitivity
    }
    val negInertiaPower = negInertia * negInertiaScalar
    p.negInertiaAccumulator += negInertiaPower

    wheel += p.negInertiaAccumulator
    if (p.negInertiaAccumulator > 1.0) {
        p.negInertiaAccumulator -= 1.0
    } else if (p.negInertiaAccumulator < -1.0) {
        p.negInertiaAccumulator += 1.0
    } else {
        p.negInertiaAccumulator = 0.0
    }
    linearPower = throttle

    if (quickTurn) {
        if (Math.abs(linearPower) < p.quickStopDeadband) {
            val alpha = p.quickStopWeight
            p.quickStopAccumulator = (1 - alpha) * p.quickStopAccumulator
            + alpha * Math.min(1.0, Math.max(-1.0, wheel)) * p.quickStopScalar
        }
        overPower = 1.0
        angularPower = wheel
    } else {
        overPower = 0.0
        angularPower = Math.abs(throttle) * wheel * sensitivity - p.quickStopAccumulator
        if (p.quickStopAccumulator > 1) {
            p.quickStopAccumulator -= 1.0
        } else if (p.quickStopAccumulator < -1) {
            p.quickStopAccumulator += 1
        } else {
            p.quickStopAccumulator = 0.0
        }
    }

    leftOut = linearPower + angularPower
    rightOut = linearPower - angularPower

    if (leftOut > 1.0) {
        rightOut -= overPower * (leftOut - 1.0)
        leftOut = 1.0
    } else if (rightOut > 1.0) {
        leftOut -= overPower * (rightOut - 1.0)
        rightOut = 1.0
    } else if (leftOut < -1.0) {
        rightOut += overPower * (-1.0 - leftOut)
        leftOut = -1.0
    } else if (rightOut < -1.0) {
        leftOut += overPower * (-1.0 - rightOut)
        rightOut = -1.0
    }

    tank(mode, leftOut * p.outputScalar, rightOut * p.outputScalar)
}