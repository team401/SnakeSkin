package org.snakeskin.component.impl

import com.revrobotics.*
import org.snakeskin.component.ISparkMaxDevice
import org.snakeskin.component.SparkMaxOutputVoltageReadingMode
import org.snakeskin.component.provider.IFollowableProvider
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRevolutions
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRevolutionsPerMinute
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRevolutionsPerSecond
import org.snakeskin.runtime.SnakeskinRuntime

class HardwareSparkMaxDevice(val device: CANSparkMax, val voltageReadingMode: SparkMaxOutputVoltageReadingMode, useExternalEncoderPinout: Boolean = false, encoderCpr: Int = 0) : ISparkMaxDevice {
    private val encoder = if (useExternalEncoderPinout) {
        device.getAlternateEncoder(AlternateEncoderType.kQuadrature, encoderCpr) //Use alternate pinout if selected
    } else {
        if (device.initialMotorType == CANSparkMaxLowLevel.MotorType.kBrushless) {
            device.encoder //Use brushless encoder
        } else {
            device.getEncoder(EncoderType.kQuadrature, encoderCpr) //Use user specified encoder
        }
    }

    private val pidController = device.pidController

    private fun getOutputVoltageMultiplier(): Double {
        return when (voltageReadingMode) {
            SparkMaxOutputVoltageReadingMode.MultiplyVbusSystem -> SnakeskinRuntime.voltage
            SparkMaxOutputVoltageReadingMode.MultiplyVbusDevice -> device.busVoltage
        }
    }

    override fun follow(master: IFollowableProvider) {
        when (master) {
            is HardwareSparkMaxDevice -> device.follow(master.device)
        }
    }

    override fun unfollow() {
        //TODO check if this actually unfollows, or if we need to set 0 instead
        device.follow(CANSparkMax.ExternalFollower.kFollowerDisabled, 0)
    }

    override fun getInputVoltage(): Double {
        return device.busVoltage
    }

    override fun setPercentOutput(percentOut: Double) {
        device.set(percentOut)
    }

    override fun getPercentOutput(): Double {
        return device.appliedOutput
    }

    override fun stop() {
        device.stopMotor()
    }

    override fun getOutputVoltage(): Double {
        return device.appliedOutput * getOutputVoltageMultiplier()
    }

    override fun getAngularPosition(): AngularDistanceMeasureRevolutions {
        return AngularDistanceMeasureRevolutions(encoder.position)
    }

    override fun setAngularPosition(angle: AngularDistanceMeasureRevolutions) {
        encoder.position = angle.value
    }

    override fun getAngularVelocity(): AngularVelocityMeasureRevolutionsPerSecond {
        return AngularVelocityMeasureRevolutionsPerMinute(encoder.velocity).toRevolutionsPerSecond()
    }

    override fun getOutputCurrent(): Double {
        return device.outputCurrent
    }

    override fun setAngularPositionSetpoint(setpoint: AngularDistanceMeasureRevolutions, ffVolts: Double) {
        pidController.setReference(setpoint.value, ControlType.kPosition, 0, ffVolts, CANPIDController.ArbFFUnits.kVoltage)
    }

    override fun setAngularVelocitySetpoint(setpoint: AngularVelocityMeasureRevolutionsPerSecond, ffVolts: Double) {
        val velocity = setpoint.toRevolutionsPerMinute().value
        pidController.setReference(velocity, ControlType.kVelocity, 0, ffVolts, CANPIDController.ArbFFUnits.kVoltage)
    }

    override fun setProfiledSetpoint(setpoint: AngularDistanceMeasureRevolutions, ffVolts: Double) {
        pidController.setReference(setpoint.value, ControlType.kSmartMotion, 0, ffVolts, CANPIDController.ArbFFUnits.kVoltage)
    }

    override fun invertOutput(invert: Boolean) {
        device.inverted = invert
    }

    override fun invertInput(invert: Boolean) {
        encoder.inverted = invert
    }
}