package org.snakeskin.component

import com.ctre.phoenix.ErrorCode
import com.ctre.phoenix.motorcontrol.*
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRadians
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRadiansPerSecond
import org.snakeskin.template.PIDFTemplate

/**
 * @author Cameron Earle
 * @version 1/24/2019
 *
 */
interface ICTREGearbox: ISmartGearbox<IMotorController> {
    fun set(mode: ControlMode, setpoint: Double)
    fun set(mode: ControlMode, setpoint: Double, arbFF: Double)

    fun setNeutralMode(mode: NeutralMode)
    fun setSensorPhase(phase: Boolean)

    fun setRampRate(openLoopSecondsFromNeutralToFull: Double, closedLoopSecondsFromNeutralToFull: Double, timeoutMs: Int = 0): ErrorCode
    fun setPeakOutput(forwardPercent: Double, reversePercent: Double, timeoutMs: Int): ErrorCode
    fun setMinimumOutput(forwardPercent: Double, reversePercent: Double, timeoutMs: Int = 0): ErrorCode
    fun setDeadband(percent: Double, timeoutMs: Int = 0): ErrorCode
    fun setVoltageCompenstion(maximumVoltage: Double, timeoutMs: Int = 0): ErrorCode

    fun getMasterTemperatureCelsius(): Double
    fun setFeedbackSensor(device: RemoteFeedbackDevice, pidIdx: Int = 0, timeoutMs: Int = 0): ErrorCode
    fun getPosition(pidIdx: Int): AngularDistanceMeasureRadians
    fun getVelocity(pidIdx: Int): AngularVelocityMeasureRadiansPerSecond
    fun setPosition(position: AngularDistanceMeasureRadians, pidIdx: Int)
    fun setForwardLimitSwitch(source: RemoteLimitSwitchSource, normal: LimitSwitchNormal, deviceId: Int, timeoutMs: Int = 0): ErrorCode
    fun setReverseLimitSwitch(source: RemoteLimitSwitchSource, normal: LimitSwitchNormal, deviceId: Int, timeoutMs: Int = 0): ErrorCode
    fun setForwardSoftLimit(enable: Boolean, limit: AngularDistanceMeasureRadians, timeoutMs: Int = 0): ErrorCode
    fun setReverseSoftLimit(enable: Boolean, limit: AngularDistanceMeasureRadians, timeoutMs: Int = 0): ErrorCode
    fun setPIDF(kP: Double = 0.0, kI: Double = 0.0, kD: Double = 0.0, kF: Double = 0.0, slotIdx: Int = 0, timeoutMs: Int = 0): ErrorCode
    fun setPIDF(template: PIDFTemplate, slotIdx: Int = 0, timeoutMs: Int = 0): ErrorCode {
        return setPIDF(
                template.kP,
                template.kI,
                template.kD,
                template.kF,
                slotIdx,
                timeoutMs
        )
    }
    fun hasMasterResetOccurred(): Boolean
    fun hasSlaveResetOccurred(): Boolean
    fun hasSlaveResetOccurred(idx: Int): Boolean

    fun hasAnyResetOccurred(): Boolean {
        return hasMasterResetOccurred() || hasSlaveResetOccurred()
    }

    /**
     * Runs an action on all of the motor controllers in the gearbox
     */
    fun all(action: IMotorController.() -> Unit)

    /**
     * Runs an action on all of the slave motor controllers in the gearbox
     */
    fun slaves(action: IMotorController.() -> Unit)
}