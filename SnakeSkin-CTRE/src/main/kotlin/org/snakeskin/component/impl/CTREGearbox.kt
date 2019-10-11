package org.snakeskin.component.impl

import com.ctre.phoenix.ErrorCode
import com.ctre.phoenix.motorcontrol.*
import org.snakeskin.component.ICTREGearbox
import org.snakeskin.component.ISmartGearbox
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRadians
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRadiansPerSecond
import org.snakeskin.template.PIDFTemplate

/**
 * @author Cameron Earle
 * @version 1/28/2019
 *
 *
 * This assumes you are using a mag encoder.
 */
@Deprecated("Replaced with new component system")
open class CTREGearbox<out M: IMotorController>(val master: M, vararg val slaves: IMotorController,
                  private val nativeUnitsToRadians: Double = (2 * Math.PI) / 4096.0,
                  private val nativeUnitsToRadiansPerSecond: Double = (20.0 * Math.PI) / 4096.0): ICTREGearbox {
    init {
        link()
    }

    override fun setNeutralMode(mode: ISmartGearbox.CommonNeutralMode): Boolean {
        when (mode) {
            ISmartGearbox.CommonNeutralMode.BRAKE -> setNeutralMode(NeutralMode.Brake)
            ISmartGearbox.CommonNeutralMode.COAST -> setNeutralMode(NeutralMode.Coast)
        }
        return true
    }

    override fun setRampRate(secondsFromNeutralToFull: Double): Boolean {
        return setRampRate(secondsFromNeutralToFull, secondsFromNeutralToFull) == ErrorCode.OK
    }

    override fun setDeadband(deadbandPercent: Double): Boolean {
        return setDeadband(deadbandPercent, 0) == ErrorCode.OK
    }

    override fun set(controlMode: ISmartGearbox.CommonControlMode, setpoint: Double) {
        when (controlMode) {
            ISmartGearbox.CommonControlMode.PERCENTAGE -> set(ControlMode.PercentOutput, setpoint)
            ISmartGearbox.CommonControlMode.POSITION -> set(ControlMode.Position, setpoint)
            ISmartGearbox.CommonControlMode.VELOCITY -> set(ControlMode.Velocity, setpoint)
        }
    }

    override fun set(controlMode: ISmartGearbox.CommonControlMode, setpoint: Double, arbFF: Double) {
        when (controlMode) {
            ISmartGearbox.CommonControlMode.PERCENTAGE -> set(ControlMode.PercentOutput, setpoint, arbFF)
            ISmartGearbox.CommonControlMode.POSITION -> set(ControlMode.Position, setpoint, arbFF)
            ISmartGearbox.CommonControlMode.VELOCITY -> set(ControlMode.Velocity, setpoint, arbFF)
        }
    }

    override fun getMasterVbus(): Double {
        return master.busVoltage
    }

    /**
     * IMotorController doesn't support current measurements, so this implementation returns 0 if the master isn't
     * an IMotorControllerEnhanced
     */
    override fun getMasterOutputCurrent(): Double {
        if (master is IMotorControllerEnhanced) {
            return master.outputCurrent
        }
        return 0.0
    }

    override fun setPIDF(kP: Double, kI: Double, kD: Double, kF: Double, slot: Int): Boolean {
        return setPIDF(kP, kI, kD, kF, slot, 0) == ErrorCode.OK
    }

    override fun setPIDF(template: PIDFTemplate, slot: Int): Boolean {
        return setPIDF(template, slot, 0) == ErrorCode.OK
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

    override fun getPosition(pidIdx: Int): AngularDistanceMeasureRadians {
        return AngularDistanceMeasureRadians(master.getSelectedSensorPosition(pidIdx) * nativeUnitsToRadians)
    }

    override fun getPosition(): AngularDistanceMeasureRadians {
        return getPosition(0)
    }

    override fun getVelocity(pidIdx: Int): AngularVelocityMeasureRadiansPerSecond {
        return AngularVelocityMeasureRadiansPerSecond(master.getSelectedSensorVelocity(pidIdx) * nativeUnitsToRadiansPerSecond)
    }

    override fun getVelocity(): AngularVelocityMeasureRadiansPerSecond {
        return getVelocity(0)
    }

    override fun setPosition(position: AngularDistanceMeasureRadians, pidIdx: Int) {
        master.setSelectedSensorPosition((position.value / nativeUnitsToRadians).toInt(), pidIdx, 0)
    }

    override fun setPosition(position: AngularDistanceMeasureRadians) {
        setPosition(position, 0)
    }

    override fun setForwardLimitSwitch(source: RemoteLimitSwitchSource, normal: LimitSwitchNormal, deviceId: Int, timeoutMs: Int): ErrorCode {
        return master.configForwardLimitSwitchSource(source, normal, deviceId, timeoutMs)
    }

    override fun setReverseLimitSwitch(source: RemoteLimitSwitchSource, normal: LimitSwitchNormal, deviceId: Int, timeoutMs: Int): ErrorCode {
        return master.configReverseLimitSwitchSource(source, normal, deviceId, timeoutMs)
    }

    override fun setForwardSoftLimit(enable: Boolean, limit: AngularDistanceMeasureRadians, timeoutMs: Int): ErrorCode {
        return ErrorCode.worstOne(
                master.configForwardSoftLimitEnable(enable, timeoutMs),
                master.configForwardSoftLimitThreshold(((limit.value) / nativeUnitsToRadians).toInt(), timeoutMs)
        )
    }

    override fun setReverseSoftLimit(enable: Boolean, limit: AngularDistanceMeasureRadians, timeoutMs: Int): ErrorCode {
        return ErrorCode.worstOne(
                master.configReverseSoftLimitEnable(enable, timeoutMs),
                master.configReverseSoftLimitThreshold(((limit.value) / nativeUnitsToRadians).toInt(), timeoutMs)
        )
    }

    override fun setPIDF(kP: Double, kI: Double, kD: Double, kF: Double, slotIdx: Int, timeoutMs: Int): ErrorCode {
        return ErrorCode.worstOne(
                master.config_kP(slotIdx, kP, timeoutMs),
                master.config_kI(slotIdx, kI, timeoutMs),
                master.config_kD(slotIdx, kD, timeoutMs),
                master.config_kF(slotIdx, kF, timeoutMs)
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

    override fun all(action: IMotorController.() -> Unit) {
        action(master)
        slaves(action)
    }

    override fun slaves(action: IMotorController.() -> Unit) {
        slaves.forEach {
            action(it)
        }
    }

    final override fun link() {
        slaves.forEach {
            it.follow(master)
        }
    }
}