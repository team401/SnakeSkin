package org.snakeskin.component.impl

import com.revrobotics.*
import org.snakeskin.component.ISparkMaxDevice
import org.snakeskin.component.SparkMaxOutputVoltageReadingMode
import org.snakeskin.component.provider.IFollowableProvider
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRadians
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRevolutions
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRadiansPerSecond
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRevolutionsPerMinute
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
    private var master: CANSparkMax? = null

    private fun getOutputVoltageMultiplier(): Double {
        return when (voltageReadingMode) {
            SparkMaxOutputVoltageReadingMode.MultiplyVbusSystem -> SnakeskinRuntime.voltage
            SparkMaxOutputVoltageReadingMode.MultiplyVbusDevice -> device.busVoltage
        }
    }

    override fun follow(master: IFollowableProvider) {
        when (master) {
            is HardwareSparkMaxDevice -> {
                device.follow(master.device)
                this.master = master.device //Store the master object for re-following later
            }
        }
    }

    override fun unfollow() {
        device.set(0.0)
        master = null //This call un-follows, so null the master field
    }

    override fun getInputVoltage(): Double {
        return device.busVoltage
    }

    override fun setPercentOutput(percentOut: Double) {
        device.set(percentOut)
        master = null
    }

    override fun getPercentOutput(): Double {
        return device.appliedOutput
    }

    override fun stop() {
        device.stopMotor()
        master = null
    }

    override fun getOutputVoltage(): Double {
        return device.appliedOutput * getOutputVoltageMultiplier()
    }

    override fun getAngularPosition(): AngularDistanceMeasureRadians {
        return AngularDistanceMeasureRevolutions(encoder.position).toRadians()
    }

    override fun setAngularPosition(angle: AngularDistanceMeasureRadians) {
        encoder.position = angle.toRevolutions().value
    }

    override fun getAngularVelocity(): AngularVelocityMeasureRadiansPerSecond {
        return AngularVelocityMeasureRevolutionsPerMinute(encoder.velocity).toRadiansPerSecond()
    }

    override fun getOutputCurrent(): Double {
        return device.outputCurrent
    }

    override fun setAngularPositionSetpoint(setpoint: AngularDistanceMeasureRadians, ffVolts: Double) {
        pidController.setReference(setpoint.toRevolutions().value, ControlType.kPosition, 0, ffVolts, CANPIDController.ArbFFUnits.kVoltage)
        master = null
    }

    override fun setAngularVelocitySetpoint(setpoint: AngularVelocityMeasureRadiansPerSecond, ffVolts: Double) {
        val velocity = setpoint.toRevolutionsPerMinute().value
        pidController.setReference(velocity, ControlType.kVelocity, 0, ffVolts, CANPIDController.ArbFFUnits.kVoltage)
        master = null
    }

    override fun setProfiledSetpoint(setpoint: AngularDistanceMeasureRadians, ffVolts: Double) {
        pidController.setReference(setpoint.toRevolutions().value, ControlType.kSmartMotion, 0, ffVolts, CANPIDController.ArbFFUnits.kVoltage)
        master = null
    }

    override fun invert(invert: Boolean) {
        if (master != null) {
            device.follow(master, invert) //Re-follow with invert command (required to stay following the master)
        } else {
            device.inverted = invert
        }
    }

    override fun invertInput(invert: Boolean) {
        encoder.inverted = invert
    }
}