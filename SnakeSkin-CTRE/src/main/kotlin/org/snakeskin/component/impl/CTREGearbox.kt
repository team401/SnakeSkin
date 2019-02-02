package org.snakeskin.component.impl

import com.ctre.phoenix.ErrorCode
import com.ctre.phoenix.motorcontrol.*
import org.snakeskin.component.ICTREGearbox
import org.snakeskin.units.AngularDistanceUnit
import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasure
import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasureCTREMagEncoder
import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasureRadians
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasureCTREMagEncoder
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasureRadiansPerSecond

/**
 * @author Cameron Earle
 * @version 1/28/2019
 *
 *
 * This assumes you are using a mag encoder.
 */
open class CTREGearbox<out M: IMotorController>(val master: M, vararg val slaves: IMotorController,
                  private val nativeUnitsToRadians: Double = AngularDistanceMeasureCTREMagEncoder.MAG_ENCODER_TICKS_TO_RADIANS,
                  private val nativeUnitsToRadiansPerSecond: Double = AngularVelocityMeasureCTREMagEncoder.MAG_ENCODER_TICKS_PER_HUNDRED_MS_TO_RADIANS_PER_SECOND): ICTREGearbox {
    init {
        slaves.forEach {
            it.follow(master)
        }
    }

    override fun set(mode: ControlMode, setpoint: Double) {
        master.set(mode, setpoint)
    }

    override fun set(mode: ControlMode, setpoint: Double, arbFF: Double) {
        master.set(mode, setpoint, DemandType.ArbitraryFeedForward, arbFF)
    }

    override fun set(setpoint: Double) {
        set(ControlMode.PercentOutput, setpoint)
    }

    override fun setNeutralMode(mode: NeutralMode) {
        master.setNeutralMode(mode)
        slaves.forEach {
            it.setNeutralMode(mode)
        }
    }

    override fun setSensorPhase(phase: Boolean) {
        master.setSensorPhase(phase)
    }

    override fun setRampRate(openLoopSecondsFromNeutralToFull: Double, closedLoopSecondsFromNeutralToFull: Double, timeoutMs: Int): ErrorCode {
        return ErrorCode.worstOne(
                master.configOpenloopRamp(openLoopSecondsFromNeutralToFull, timeoutMs),
                master.configClosedloopRamp(closedLoopSecondsFromNeutralToFull, timeoutMs)
        )
    }

    override fun setPeakOutput(forwardPercent: Double, reversePercent: Double, timeoutMs: Int): ErrorCode {
        return ErrorCode.worstOne(
                master.configPeakOutputForward(forwardPercent, timeoutMs),
                master.configPeakOutputReverse(reversePercent, timeoutMs)
        )
    }

    override fun setMinimumOutput(forwardPercent: Double, reversePercent: Double, timeoutMs: Int): ErrorCode {
        return ErrorCode.worstOne(
                master.configNominalOutputForward(forwardPercent, timeoutMs),
                master.configNominalOutputReverse(reversePercent, timeoutMs)
        )
    }

    override fun setDeadband(percent: Double, timeoutMs: Int): ErrorCode {
        return master.configNeutralDeadband(percent, timeoutMs)
    }

    override fun setVoltageCompenstion(maximumVoltage: Double, timeoutMs: Int): ErrorCode {
        if (maximumVoltage == 0.0) {
            master.enableVoltageCompensation(false)
        } else {
            master.enableVoltageCompensation(true)
        }
        return master.configVoltageCompSaturation(maximumVoltage, timeoutMs)
    }

    override fun getMasterVbusVolts(): Double {
        return master.busVoltage
    }

    override fun getOutputPercent(): Double {
        return master.motorOutputPercent
    }

    override fun getOutputVoltage(): Double {
        return master.motorOutputVoltage
    }

    override fun getMasterTemperatureCelsius(): Double {
        return master.temperature
    }

    override fun setFeedbackSensor(device: RemoteFeedbackDevice, pidIdx: Int, timeoutMs: Int): ErrorCode {
        return master.configSelectedFeedbackSensor(device, pidIdx, timeoutMs)
    }

    override fun getPositionRadians(pidIdx: Int): Double {
        return master.getSelectedSensorPosition(pidIdx) * nativeUnitsToRadians
    }

    override fun getPositionRadians(): Double {
        return getPositionRadians(0)
    }

    override fun getVelocityRadiansPerSecond(pidIdx: Int): Double {
        return master.getSelectedSensorVelocity(pidIdx) * nativeUnitsToRadiansPerSecond
    }

    override fun getVelocityRadiansPerSecond(): Double {
        return getVelocityRadiansPerSecond(0)
    }

    override fun getPosition(pidIdx: Int): AngularDistanceMeasureRadians {
        return AngularDistanceMeasureRadians(getPositionRadians(pidIdx))
    }

    override fun getPosition(): AngularDistanceMeasureRadians {
        return getPosition(0)
    }

    override fun getVelocity(pidIdx: Int): AngularVelocityMeasureRadiansPerSecond {
        return AngularVelocityMeasureRadiansPerSecond(getVelocityRadiansPerSecond(pidIdx))
    }

    override fun getVelocity(): AngularVelocityMeasureRadiansPerSecond {
        return getVelocity(0)
    }

    override fun setPosition(position: AngularDistanceMeasure, pidIdx: Int) {
        master.setSelectedSensorPosition((position.toUnit(AngularDistanceUnit.Standard.RADIANS).value / nativeUnitsToRadiansPerSecond).toInt(), pidIdx, 0)
    }

    override fun setPosition(position: AngularDistanceMeasure) {
        setPosition(position, 0)
    }

    override fun setForwardLimitSwitch(source: RemoteLimitSwitchSource, normal: LimitSwitchNormal, deviceId: Int, timeoutMs: Int): ErrorCode {
        return master.configForwardLimitSwitchSource(source, normal, deviceId, timeoutMs)
    }

    override fun setReverseLimitSwitch(source: RemoteLimitSwitchSource, normal: LimitSwitchNormal, deviceId: Int, timeoutMs: Int): ErrorCode {
        return master.configReverseLimitSwitchSource(source, normal, deviceId, timeoutMs)
    }

    override fun setForwardSoftLimit(enable: Boolean, limit: AngularDistanceMeasure, timeoutMs: Int): ErrorCode {
        return ErrorCode.worstOne(
                master.configForwardSoftLimitEnable(enable, timeoutMs),
                master.configForwardSoftLimitThreshold(((limit.toUnit(AngularDistanceUnit.Standard.RADIANS).value) / nativeUnitsToRadians).toInt(), timeoutMs)
        )
    }

    override fun setReverseSoftLimit(enable: Boolean, limit: AngularDistanceMeasure, timeoutMs: Int): ErrorCode {
        return ErrorCode.worstOne(
                master.configReverseSoftLimitEnable(enable, timeoutMs),
                master.configReverseSoftLimitThreshold(((limit.toUnit(AngularDistanceUnit.Standard.RADIANS).value) / nativeUnitsToRadians).toInt(), timeoutMs)
        )
    }

    override fun setPIDF(p: Double, i: Double, d: Double, f: Double, slotIdx: Int, timeoutMs: Int): ErrorCode {
        return ErrorCode.worstOne(
                master.config_kP(slotIdx, p, timeoutMs),
                master.config_kI(slotIdx, i, timeoutMs),
                master.config_kD(slotIdx, d, timeoutMs),
                master.config_kF(slotIdx, f, timeoutMs)
        )
    }

    override fun hasMasterResetOccurred(): Boolean {
        return master.hasResetOccurred()
    }

    override fun hasSlaveResetOccurred(): Boolean {
        return slaves.any { it.hasResetOccurred() }
    }

    override fun hasSlaveResetOccurred(idx: Int): Boolean {
        return slaves[idx].hasResetOccurred()
    }

    override fun get(): Double {
        return getOutputPercent()
    }

    override fun stop() {
        master.neutralOutput()
    }

    override var inverted: Boolean
        get() = master.inverted && slaves.all { it.inverted }
        set(value) {
            master.inverted = value
            slaves.forEach {
                it.inverted = value
            }
        }
}