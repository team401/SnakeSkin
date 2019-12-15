package org.snakeskin.utility

import org.snakeskin.component.IDifferentialDrivetrain
import org.snakeskin.logic.scalars.NoScaling
import org.snakeskin.logic.scalars.Scalar
import org.snakeskin.template.CheesyDriveParametersTemplate
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sin

/**
 * @author Cameron Earle
 * @version 12/8/2018
 *
 *  Implements the Cheesy Poofs "Cheesy Drive"
 */
class CheesyDriveController(private val config: CheesyDriveParametersTemplate = DefaultParameters()) {
    open class DefaultParameters: CheesyDriveParametersTemplate {
        override val highWheelNonLinearity: Double = 0.65
        override val lowWheelNonLinearity: Double = 0.5
        override val highNegInertiaScalar: Double = 4.0
        override val lowNegInertiaThreshold: Double = 0.65
        override val lowNegInertiaTurnScalar: Double = 3.5
        override val lowNegInertiaCloseScalar: Double = 4.0
        override val lowNegInertiaFarScalar: Double = 5.0
        override val highSensitivity: Double = 0.95
        override val lowSensitivity: Double = 1.3
        override val quickStopDeadband: Double = 0.2
        override val quickStopWeight: Double = 0.1
        override val quickStopScalar: Double = 5.0
        override val lowSinCount: Int = 3
        override val highSinCount: Int = 2
        override val outputScalar: Double = 1.0
        override val quickTurnScalar: Scalar = NoScaling
    }

    data class Output(val left: Double, val right: Double) {
        /**
         * Runs the command on a drivetrain
         */
        fun applyTo(drivetrain: IDifferentialDrivetrain) {
            drivetrain.tank(left, right)
        }
    }

    private var oldWheel = 0.0
    private var quickStopAccumulator = 0.0
    private var negInertiaAccumulator = 0.0

    private val highDenom = sin(Math.PI / 2.0 * config.highWheelNonLinearity)
    private val lowDenom = sin(Math.PI / 2.0 * config.lowWheelNonLinearity)

    fun reset() {
        oldWheel = 0.0
        quickStopAccumulator = 0.0
        negInertiaAccumulator = 0.0
    }

    fun update(throttleIn: Double, wheelIn: Double, isHigh: Boolean, quickTurn: Boolean = false): Output {
        var wheel = wheelIn

        if (quickTurn) {
            wheel = config.quickTurnScalar.scale(wheel)
        }

        val negInertia = wheel - oldWheel
        oldWheel = wheel

        if (isHigh) {
            for (i in 0 until config.highSinCount) {
                wheel = sin(Math.PI / 2.0 * config.highWheelNonLinearity * wheel) / highDenom
            }
        } else {
            for (i in 0 until config.lowSinCount) {
                wheel = sin(Math.PI / 2.0 * config.lowWheelNonLinearity * wheel) / lowDenom
            }
        }

        var leftOut: Double
        var rightOut: Double
        val overPower: Double
        val sensitivity: Double
        val angularPower: Double
        val linearPower: Double = throttleIn
        val negInertiaScalar: Double

        if (isHigh) {
            negInertiaScalar = config.highNegInertiaScalar
            sensitivity = config.highSensitivity
        } else {
            negInertiaScalar = if (wheel * negInertia > 0) {
                config.lowNegInertiaTurnScalar
            } else {
                if (abs(wheel) > config.lowNegInertiaThreshold) {
                    config.lowNegInertiaFarScalar
                } else {
                    config.lowNegInertiaCloseScalar
                }
            }
            sensitivity = config.lowSensitivity
        }
        val negInertiaPower = negInertia * negInertiaScalar
        negInertiaAccumulator += negInertiaPower

        wheel += negInertiaAccumulator
        when {
            negInertiaAccumulator > 1.0 -> negInertiaAccumulator -= 1.0
            negInertiaAccumulator < -1.0 -> negInertiaAccumulator += 1.0
            else -> negInertiaAccumulator = 0.0
        }

        if (quickTurn) {
            if (abs(linearPower) < config.quickStopDeadband) {
                val alpha = config.quickStopWeight
                quickStopAccumulator *= (1 - alpha)
                + alpha * min(1.0, max(-1.0, wheel)) * config.quickStopScalar
            }
            overPower = 1.0
            angularPower = wheel
        } else {
            overPower = 0.0
            angularPower = abs(throttleIn) * wheel * sensitivity - quickStopAccumulator
            when {
                quickStopAccumulator > 1 -> quickStopAccumulator -= 1.0
                quickStopAccumulator < -1 -> quickStopAccumulator += 1
                else -> quickStopAccumulator = 0.0
            }
        }

        leftOut = linearPower + angularPower
        rightOut = linearPower - angularPower

        when {
            leftOut > 1.0 -> {
                rightOut -= overPower * (leftOut - 1.0)
                leftOut = 1.0
            }
            rightOut > 1.0 -> {
                leftOut -= overPower * (rightOut - 1.0)
                rightOut = 1.0
            }
            leftOut < -1.0 -> {
                rightOut += overPower * (-1.0 - leftOut)
                leftOut = -1.0
            }
            rightOut < -1.0 -> {
                leftOut += overPower * (-1.0 - rightOut)
                rightOut = -1.0
            }
        }

        return Output(leftOut * config.outputScalar, rightOut * config.outputScalar)
    }
}