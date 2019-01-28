package org.snakeskin.component

import com.ctre.phoenix.ErrorCode
import com.ctre.phoenix.motorcontrol.*
import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasure
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasure

/**
 * @author Cameron Earle
 * @version 1/24/2019
 *
 */
interface ICTREGearbox: ISensoredGearbox {
    fun setFeedbackSensor(sensor: FeedbackDevice, pidIdx: Int = 0, timeoutMs: Int = 0): ErrorCode
    fun setFeedbackSensor(sensor: RemoteFeedbackDevice, pidIdx: Int = 0, timeoutMs: Int = 0)
    fun getMasterCurrentAmps(): Double
    fun setForwardLimitSwitch(source: LimitSwitchSource, normal: LimitSwitchNormal, timeoutMs: Int = 0): ErrorCode
    fun setReverseLimitSwitch(source: LimitSwitchSource, normal: LimitSwitchNormal, timeoutMs: Int = 0): ErrorCode
    fun setForwardLimitSwitch(source: RemoteLimitSwitchSource, normal: LimitSwitchNormal, deviceId: Int, timeoutMs: Int = 0): ErrorCode
    fun setReverseLimitSwitch(source: RemoteLimitSwitchSource, normal: LimitSwitchNormal, deviceId: Int, timeoutMs: Int = 0): ErrorCode
    fun setCurrentLimit(continuousCurrentAmps: Int, peakCurrentAmps: Int, peakCurrentDurationMs: Int, timeoutMs: Int = 0): ErrorCode
    fun getMasterSensorCollection(): SensorCollection

    fun set(mode: ControlMode, setpoint: Double)
    fun set(mode: ControlMode, setpoint: Double, arbFF: Double)

    fun setNeutralMode(mode: NeutralMode)
    fun setSensorPhase(phase: Boolean)
    fun setOpenLoopRampRate(secondsFromNeutralToFull: Double, timeoutMs: Int = 0): ErrorCode
    fun setClosedLoopRampRate(secondsFromNeutralToFull: Double, timeoutMs: Int = 0): ErrorCode
    fun setPeakOutput(forwardPercent: Double, reversePercent: Double, timeoutMs: Int = 0): ErrorCode
    fun setMinOutput(forwardPercent: Double, reversePercent: Double, timeoutMs: Int = 0): ErrorCode
    fun setDeadband(percent: Double, timeoutMs: Int = 0): ErrorCode
    fun setVoltageCompensation(referenceVoltage: Double, timeoutMs: Int = 0): ErrorCode
    fun getVbus(): Double
    fun getPercentOutput(): Double
    fun getVoltageOutput(): Double

    fun getPosition(pidIdx: Int): AngularDistanceMeasure
    fun getVelocity(pidIdx: Int): AngularVelocityMeasure
    fun setPosition(position: AngularDistanceMeasure, pidIdx: Int = 0, timeoutMs: Int = 0): ErrorCode
    fun setForwardSoftLimit(limit: Int, timeoutMs: Int = 0)
}