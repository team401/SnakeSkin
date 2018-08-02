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
    override fun configSetParameter(param: ParamEnum?, value: Double, subValue: Int, ordinal: Int, timeoutMs: Int) = ErrorCode.OK

    override fun configSetParameter(param: Int, value: Double, subValue: Int, ordinal: Int, timeoutMs: Int) = ErrorCode.OK

    override fun configSetCustomParam(newValue: Int, paramIndex: Int, timeoutMs: Int) = ErrorCode.OK

    override fun getFirmwareVersion(): Int {
        return -1
    }
    

    override fun configContinuousCurrentLimit(amps: Int, timeoutMs: Int) = ErrorCode.OK

    override fun configForwardSoftLimitThreshold(forwardSensorLimit: Int, timeoutMs: Int) = ErrorCode.OK

    override fun configVoltageMeasurementFilter(filterWindowSamples: Int, timeoutMs: Int) = ErrorCode.OK        
    

    override fun configMotionAcceleration(sensorUnitsPer100msPerSec: Int, timeoutMs: Int) = ErrorCode.OK        
    

    override fun enableVoltageCompensation(enable: Boolean) {}
        
    

    override fun configPeakCurrentLimit(amps: Int, timeoutMs: Int) = ErrorCode.OK        
    

    override fun overrideLimitSwitchesEnable(enable: Boolean) {}
        
    

    override fun config_kI(slotIdx: Int, value: Double, timeoutMs: Int) = ErrorCode.OK        
    

    override fun getMotorOutputVoltage() = 0.0
        
    

    override fun getDeviceID() = 0
        
    

    override fun configReverseLimitSwitchSource(type: LimitSwitchSource?, normalOpenOrClose: LimitSwitchNormal?, timeoutMs: Int) = ErrorCode.OK        
    

    override fun configReverseLimitSwitchSource(type: RemoteLimitSwitchSource?, normalOpenOrClose: LimitSwitchNormal?, deviceID: Int, timeoutMs: Int) = ErrorCode.OK        
    

    override fun getMotionProfileStatus(statusToFill: MotionProfileStatus?) = ErrorCode.OK        
    

    override fun configPeakCurrentDuration(milliseconds: Int, timeoutMs: Int) = ErrorCode.OK        
    

    override fun getIntegralAccumulator(pidIdx: Int) = 0.0
        
    

    override fun getMotorOutputPercent() = 0.0
        
    

    override fun config_IntegralZone(slotIdx: Int, izone: Int, timeoutMs: Int) = ErrorCode.OK        
    

    override fun setNeutralMode(neutralMode: NeutralMode?) {}
        
    

    override fun follow(masterToFollow: IMotorController?) {}
        
    

    override fun getStickyFaults(toFill: StickyFaults?) = ErrorCode.OK        
    

    override fun setStatusFramePeriod(frame: StatusFrameEnhanced?, periodMs: Int, timeoutMs: Int) = ErrorCode.OK        
    

    override fun setStatusFramePeriod(frame: StatusFrame?, periodMs: Int, timeoutMs: Int) = ErrorCode.OK        
    

    override fun configForwardSoftLimitEnable(enable: Boolean, timeoutMs: Int) = ErrorCode.OK        
    

    override fun getActiveTrajectoryPosition() = 0
        
    

    override fun configOpenloopRamp(secondsFromNeutralToFull: Double, timeoutMs: Int) = ErrorCode.OK        
    

    override fun configVelocityMeasurementWindow(windowSize: Int, timeoutMs: Int) = ErrorCode.OK        
    

    override fun configPeakOutputReverse(percentOut: Double, timeoutMs: Int) = ErrorCode.OK        
    

    override fun getSelectedSensorPosition(pidIdx: Int) = 0
        
    

    override fun getErrorDerivative(pidIdx: Int) = 0.0
        
    

    override fun configPeakOutputForward(percentOut: Double, timeoutMs: Int) = ErrorCode.OK        
    

    override fun configVoltageCompSaturation(voltage: Double, timeoutMs: Int) = ErrorCode.OK        
    

    override fun configVelocityMeasurementPeriod(period: VelocityMeasPeriod?, timeoutMs: Int) = ErrorCode.OK        
    

    override fun config_kF(slotIdx: Int, value: Double, timeoutMs: Int) = ErrorCode.OK        
    

    override fun setIntegralAccumulator(iaccum: Double, pidIdx: Int, timeoutMs: Int) = ErrorCode.OK        
    

    override fun setControlFramePeriod(frame: ControlFrame?, periodMs: Int) = ErrorCode.OK        
    

    override fun configForwardLimitSwitchSource(type: LimitSwitchSource?, normalOpenOrClose: LimitSwitchNormal?, timeoutMs: Int) = ErrorCode.OK        
    

    override fun configForwardLimitSwitchSource(type: RemoteLimitSwitchSource?, normalOpenOrClose: LimitSwitchNormal?, deviceID: Int, timeoutMs: Int) = ErrorCode.OK        
    

    override fun getMotionProfileTopLevelBufferCount() = 0
        
    

    override fun getInverted() = false
        
    

    override fun configGetCustomParam(paramIndex: Int, timoutMs: Int) = 0
        
    

    override fun clearStickyFaults(timeoutMs: Int) = ErrorCode.OK        
    

    override fun valueUpdated() {}
        
    

    override fun configNominalOutputReverse(percentOut: Double, timeoutMs: Int) = ErrorCode.OK        
    

    override fun enableCurrentLimit(enable: Boolean) {}
        
    

    override fun getBusVoltage() = 0.0
        
    

    override fun config_kP(slotIdx: Int, value: Double, timeoutMs: Int) = ErrorCode.OK        
    

    override fun processMotionProfileBuffer() {}
        
    

    override fun getSelectedSensorVelocity(pidIdx: Int) = 0
        
    

    override fun getOutputCurrent() = 0.0
        
    

    override fun changeMotionControlFramePeriod(periodMs: Int) = ErrorCode.OK        
    

    override fun getTemperature() = 0.0
        
    

    override fun getActiveTrajectoryHeading() = 0.0
        
    

    override fun setInverted(invert: Boolean) {}
        
    

    override fun configReverseSoftLimitEnable(enable: Boolean, timeoutMs: Int) = ErrorCode.OK        
    

    override fun setSensorPhase(PhaseSensor: Boolean) {}
        
    

    override fun configMaxIntegralAccumulator(slotIdx: Int, iaccum: Double, timeoutMs: Int) = ErrorCode.OK        
    

    override fun neutralOutput() {}
        
    

    override fun configSelectedFeedbackSensor(feedbackDevice: FeedbackDevice?, pidIdx: Int, timeoutMs: Int) = ErrorCode.OK        
    

    override fun configSelectedFeedbackSensor(feedbackDevice: RemoteFeedbackDevice?, pidIdx: Int, timeoutMs: Int) = ErrorCode.OK        
    

    override fun configRemoteFeedbackFilter(deviceID: Int, remoteSensorSource: RemoteSensorSource?, remoteOrdinal: Int, timeoutMs: Int) = ErrorCode.OK        
    

    override fun configAllowableClosedloopError(slotIdx: Int, allowableCloseLoopError: Int, timeoutMs: Int) = ErrorCode.OK        
    

    override fun configNominalOutputForward(percentOut: Double, timeoutMs: Int) = ErrorCode.OK        
    

    override fun isMotionProfileTopLevelBufferFull() = false
        
    

    override fun hasResetOccurred() = false
        
    

    override fun getBaseID() = 0
        
    

    override fun setSelectedSensorPosition(sensorPos: Int, pidIdx: Int, timeoutMs: Int) = ErrorCode.OK        
    

    override fun selectProfileSlot(slotIdx: Int, pidIdx: Int) {}
        
    

    override fun getActiveTrajectoryVelocity() = 0
        
    

    override fun clearMotionProfileTrajectories() = ErrorCode.OK        
    

    override fun getClosedLoopError(pidIdx: Int) = 0
        
    

    override fun set(Mode: ControlMode?, demand: Double) {}
        
    

    override fun set(Mode: ControlMode?, demand0: Double, demand1: Double) {}
        
    

    override fun getFaults(toFill: Faults?) = ErrorCode.OK        
    

    override fun configClosedloopRamp(secondsFromNeutralToFull: Double, timeoutMs: Int) = ErrorCode.OK        
    

    override fun pushMotionProfileTrajectory(trajPt: TrajectoryPoint?) = ErrorCode.OK        
    

    override fun clearMotionProfileHasUnderrun(timeoutMs: Int) = ErrorCode.OK        
    

    override fun configNeutralDeadband(percentDeadband: Double, timeoutMs: Int) = ErrorCode.OK        
    

    override fun configReverseSoftLimitThreshold(reverseSensorLimit: Int, timeoutMs: Int) = ErrorCode.OK        
    

    override fun configGetParameter(paramEnum: ParamEnum?, ordinal: Int, timeoutMs: Int) = 0.0
        
    

    override fun configGetParameter(paramEnum: Int, ordinal: Int, timeoutMs: Int) = 0.0
        
    

    override fun configMotionCruiseVelocity(sensorUnitsPer100ms: Int, timeoutMs: Int) = ErrorCode.OK        
    

    override fun getLastError() = ErrorCode.OK        
    

    override fun overrideSoftLimitsEnable(enable: Boolean) {}
        
    

    override fun getStatusFramePeriod(frame: StatusFrameEnhanced?, timeoutMs: Int) = 0
        
    

    override fun getStatusFramePeriod(frame: StatusFrame?, timeoutMs: Int) = 0


    override fun config_kD(slotIdx: Int, value: Double, timeoutMs: Int) = ErrorCode.OK


    override fun configSensorTerm(sensorTerm: SensorTerm?, feedbackDevice: FeedbackDevice?, timeoutMs: Int) = ErrorCode.OK
}
