package org.snakeskin.component

import com.ctre.phoenix.ErrorCode
import com.ctre.phoenix.motorcontrol.*
import org.snakeskin.template.PIDFTemplate
import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasure
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasure

/**
 * @author Cameron Earle
 * @version 1/24/2019
 *
 */
interface ICTREGearbox: ISensoredGearbox {
    fun set(mode: ControlMode, setpoint: Double)
    fun set(mode: ControlMode, setpoint: Double, arbFF: Double)

    fun setNeutralMode(mode: NeutralMode)
    fun setSensorPhase(phase: Boolean)

    fun setRampRate(openLoopSecondsFromNeutralToFull: Double, closedLoopSecondsFromNeutralToFull: Double, timeoutMs: Int = 0): ErrorCode
    fun setPeakOutput(forwardPercent: Double, reversePercent: Double, timeoutMs: Int): ErrorCode
    fun setMinimumOutput(forwardPercent: Double, reversePercent: Double, timeoutMs: Int = 0): ErrorCode
    fun setDeadband(percent: Double, timeoutMs: Int = 0): ErrorCode
    fun setVoltageCompenstion(maximumVoltage: Double, timeoutMs: Int = 0): ErrorCode

    fun getMasterVbusVolts(): Double
    fun getOutputPercent(): Double
    fun getOutputVoltage(): Double
    fun getMasterTemperatureCelsius(): Double
    fun setFeedbackSensor(device: RemoteFeedbackDevice, pidIdx: Int = 0, timeoutMs: Int = 0): ErrorCode
    fun getPosition(pidIdx: Int): AngularDistanceMeasure
    fun getVelocity(pidIdx: Int): AngularVelocityMeasure
    fun getPositionRadians(pidIdx: Int): Double
    fun getVelocityRadiansPerSecond(pidIdx: Int): Double
    fun setPosition(position: AngularDistanceMeasure, pidIdx: Int)
    fun setForwardLimitSwitch(source: RemoteLimitSwitchSource, normal: LimitSwitchNormal, deviceId: Int, timeoutMs: Int = 0): ErrorCode
    fun setReverseLimitSwitch(source: RemoteLimitSwitchSource, normal: LimitSwitchNormal, deviceId: Int, timeoutMs: Int = 0): ErrorCode
    fun setForwardSoftLimit(enable: Boolean, limit: AngularDistanceMeasure, timeoutMs: Int = 0): ErrorCode
    fun setReverseSoftLimit(enable: Boolean, limit: AngularDistanceMeasure, timeoutMs: Int = 0): ErrorCode
    fun setPIDF(p: Double = 0.0, i: Double = 0.0, d: Double = 0.0, f: Double = 0.0, slotIdx: Int = 0, timeoutMs: Int = 0): ErrorCode
    fun setPIDF(template: PIDFTemplate, slotIdx: Int = 0, timeoutMs: Int = 0) {
        setPIDF(
                template.p,
                template.i,
                template.d,
                template.f,
                slotIdx,
                timeoutMs
        )
    }
    fun hasMasterResetOccurred(): Boolean
    fun hasSlaveResetOccurred(): Boolean
    fun hasSlaveResetOccurred(idx: Int): Boolean
}