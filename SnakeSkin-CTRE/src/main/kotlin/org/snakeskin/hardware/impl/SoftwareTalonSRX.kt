package org.snakeskin.hardware.impl

import com.ctre.phoenix.ErrorCode
import com.ctre.phoenix.ParamEnum
import com.ctre.phoenix.motion.MotionProfileStatus
import com.ctre.phoenix.motion.TrajectoryPoint
import com.ctre.phoenix.motorcontrol.*
import org.snakeskin.hardware.TalonSRX
import org.snakeskin.logic.LockingDelegate

/**
 * @author Cameron Earle
 * @version 7/31/18
 */
class SoftwareTalonSRX: TalonSRX {
    override val hardwareObj: Nothing? = null

    //Simulation environment
    var srxPosition by LockingDelegate(0)
    var srxVelocity by LockingDelegate(0)

    var srxCurrentLimitContinuous by LockingDelegate(0)
    var srxForwardSoftLimit by LockingDelegate(0)


    //IMotorControllerEnhanced
    override fun configSetParameter(param: ParamEnum?, value: Double, subValue: Int, ordinal: Int, timeoutMs: Int): ErrorCode {
        return ErrorCode.OK
    }

    override fun configSetParameter(param: Int, value: Double, subValue: Int, ordinal: Int, timeoutMs: Int): ErrorCode {
        return ErrorCode.OK
    }

    override fun configSetCustomParam(newValue: Int, paramIndex: Int, timeoutMs: Int): ErrorCode {
        return ErrorCode.OK
    }

    override fun getFirmwareVersion(): Int {
        return -1
    }

    override fun configContinuousCurrentLimit(amps: Int, timeoutMs: Int): ErrorCode {
        srxCurrentLimitContinuous = amps
        return ErrorCode.OK
    }

    override fun configForwardSoftLimitThreshold(forwardSensorLimit: Int, timeoutMs: Int): ErrorCode {
        srxForwardSoftLimit = forwardSensorLimit
        return ErrorCode.OK
    }

    override fun configVoltageMeasurementFilter(filterWindowSamples: Int, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configMotionAcceleration(sensorUnitsPer100msPerSec: Int, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun enableVoltageCompensation(enable: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configPeakCurrentLimit(amps: Int, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun overrideLimitSwitchesEnable(enable: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun config_kI(slotIdx: Int, value: Double, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMotorOutputVoltage(): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDeviceID(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configReverseLimitSwitchSource(type: LimitSwitchSource?, normalOpenOrClose: LimitSwitchNormal?, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configReverseLimitSwitchSource(type: RemoteLimitSwitchSource?, normalOpenOrClose: LimitSwitchNormal?, deviceID: Int, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMotionProfileStatus(statusToFill: MotionProfileStatus?): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configPeakCurrentDuration(milliseconds: Int, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getIntegralAccumulator(pidIdx: Int): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMotorOutputPercent(): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun config_IntegralZone(slotIdx: Int, izone: Int, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setNeutralMode(neutralMode: NeutralMode?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun follow(masterToFollow: IMotorController?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getStickyFaults(toFill: StickyFaults?): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setStatusFramePeriod(frame: StatusFrameEnhanced?, periodMs: Int, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setStatusFramePeriod(frame: StatusFrame?, periodMs: Int, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configForwardSoftLimitEnable(enable: Boolean, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getActiveTrajectoryPosition(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configOpenloopRamp(secondsFromNeutralToFull: Double, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configVelocityMeasurementWindow(windowSize: Int, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configPeakOutputReverse(percentOut: Double, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSelectedSensorPosition(pidIdx: Int): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getErrorDerivative(pidIdx: Int): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configPeakOutputForward(percentOut: Double, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configVoltageCompSaturation(voltage: Double, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configVelocityMeasurementPeriod(period: VelocityMeasPeriod?, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun config_kF(slotIdx: Int, value: Double, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setIntegralAccumulator(iaccum: Double, pidIdx: Int, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setControlFramePeriod(frame: ControlFrame?, periodMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configForwardLimitSwitchSource(type: LimitSwitchSource?, normalOpenOrClose: LimitSwitchNormal?, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configForwardLimitSwitchSource(type: RemoteLimitSwitchSource?, normalOpenOrClose: LimitSwitchNormal?, deviceID: Int, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMotionProfileTopLevelBufferCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getInverted(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configGetCustomParam(paramIndex: Int, timoutMs: Int): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearStickyFaults(timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun valueUpdated() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configNominalOutputReverse(percentOut: Double, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun enableCurrentLimit(enable: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBusVoltage(): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun config_kP(slotIdx: Int, value: Double, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun processMotionProfileBuffer() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSelectedSensorVelocity(pidIdx: Int): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getOutputCurrent(): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun changeMotionControlFramePeriod(periodMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTemperature(): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getActiveTrajectoryHeading(): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setInverted(invert: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configReverseSoftLimitEnable(enable: Boolean, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setSensorPhase(PhaseSensor: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configMaxIntegralAccumulator(slotIdx: Int, iaccum: Double, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun neutralOutput() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configSelectedFeedbackSensor(feedbackDevice: FeedbackDevice?, pidIdx: Int, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configSelectedFeedbackSensor(feedbackDevice: RemoteFeedbackDevice?, pidIdx: Int, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configRemoteFeedbackFilter(deviceID: Int, remoteSensorSource: RemoteSensorSource?, remoteOrdinal: Int, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configAllowableClosedloopError(slotIdx: Int, allowableCloseLoopError: Int, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configNominalOutputForward(percentOut: Double, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isMotionProfileTopLevelBufferFull(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hasResetOccurred(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBaseID(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setSelectedSensorPosition(sensorPos: Int, pidIdx: Int, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun selectProfileSlot(slotIdx: Int, pidIdx: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getActiveTrajectoryVelocity(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearMotionProfileTrajectories(): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getClosedLoopError(pidIdx: Int): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun set(Mode: ControlMode?, demand: Double) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun set(Mode: ControlMode?, demand0: Double, demand1: Double) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFaults(toFill: Faults?): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configClosedloopRamp(secondsFromNeutralToFull: Double, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun pushMotionProfileTrajectory(trajPt: TrajectoryPoint?): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearMotionProfileHasUnderrun(timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configNeutralDeadband(percentDeadband: Double, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configReverseSoftLimitThreshold(reverseSensorLimit: Int, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configGetParameter(paramEnum: ParamEnum?, ordinal: Int, timeoutMs: Int): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configGetParameter(paramEnum: Int, ordinal: Int, timeoutMs: Int): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configMotionCruiseVelocity(sensorUnitsPer100ms: Int, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLastError(): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun overrideSoftLimitsEnable(enable: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getStatusFramePeriod(frame: StatusFrameEnhanced?, timeoutMs: Int): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getStatusFramePeriod(frame: StatusFrame?, timeoutMs: Int): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun config_kD(slotIdx: Int, value: Double, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configSensorTerm(sensorTerm: SensorTerm?, feedbackDevice: FeedbackDevice?, timeoutMs: Int): ErrorCode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}