package org.snakeskin.component

import com.ctre.phoenix.motorcontrol.*
import org.snakeskin.CTREConstants

/*
 * snakeskin - Created on 12/25/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 12/25/17
 */

class Gearbox(val master: IMotorControllerEnhanced, vararg val slaves: IMotorController) {
    private fun runOnMaster(index: Int = 0, action: IMotorController.() -> Unit) {
        if (index == -1 || index == 0) {
            master.action()
        }
    }

    private fun runOnSlaves(index: Int, action: IMotorController.() -> Unit) {
        if (index == -1) {
            slaves.forEach {
                it.action()
            }
        } else if (index != 0) {
            slaves[index - 1].action()
        }
    }

    /**
     * Links the gearbox together, making all slaves follow the master
     */
    fun link() {
        slaves.forEach {
            it.follow(master)
        }
    }

    /**
     * Unlinks all motors, setting them to Percent VBus.  Useful for individual motor testing
     */
    fun unlink() {
        slaves.forEach {
            it.set(ControlMode.PercentOutput, 0.0)
        }
        master.set(ControlMode.PercentOutput, 0.0)
    }

    init {
        link()
    }

    fun set(mode: ControlMode, value: Double) = master.set(mode, value)

    fun getPosition(pidIdx: Int = CTREConstants.PID_IDX) = master.getSelectedSensorPosition(pidIdx)
    fun getVelocity(pidIdx: Int = CTREConstants.PID_IDX) = master.getSelectedSensorVelocity(pidIdx)

    fun setPosition(position: Int, pidIdx: Int = CTREConstants.PID_IDX, timeout: Int = CTREConstants.CONFIG_TIMEOUT) = master.setSelectedSensorPosition(position, pidIdx, timeout)

    fun setSensor(sensor: FeedbackDevice, pidIdx: Int = CTREConstants.PID_IDX, timeout: Int = CTREConstants.CONFIG_TIMEOUT) = master.configSelectedFeedbackSensor(sensor, pidIdx, timeout)
    fun setSensor(sensor: RemoteFeedbackDevice, pidIdx: Int = CTREConstants.PID_IDX, timeout: Int = CTREConstants.CONFIG_TIMEOUT) = master.configSelectedFeedbackSensor(sensor, pidIdx, timeout)
    fun setSensorPhase(phase: Boolean) = master.setSensorPhase(phase)

    fun setCurrentLimit(continuousCurrent: Int, peakCurrent: Int = 0, peakDuration: Int = 0, timeout: Int = CTREConstants.CONFIG_TIMEOUT) {
        if (continuousCurrent == 0) {
            master.enableCurrentLimit(false)
            return
        }
        master.enableCurrentLimit(true)
        master.configContinuousCurrentLimit(continuousCurrent, timeout)
        master.configPeakCurrentLimit(peakCurrent, timeout)
        master.configPeakCurrentDuration(peakDuration, timeout)
    }
    
    fun setRampRate(closedLoop: Double = 0.0, openLoop: Double = 0.0, timeout: Int = CTREConstants.CONFIG_TIMEOUT) {
        master.configClosedloopRamp(closedLoop, timeout)
        master.configOpenloopRamp(openLoop, timeout)
    }

    fun setOutputLimits(peakForward: Double = 1.0, peakReverse: Double = 1.0, nominalForward: Double = 1.0, nominalReverse: Double = 1.0, timeout: Int = CTREConstants.CONFIG_TIMEOUT) {
        master.configPeakOutputForward(peakForward, timeout)
        master.configPeakOutputReverse(peakReverse, timeout)
        master.configNominalOutputForward(nominalForward, timeout)
        master.configNominalOutputReverse(nominalReverse, timeout)
    }

    fun setNeutralMode(mode: NeutralMode, index: Int = -1) {
        runOnMaster(index) { this.setNeutralMode(mode) }
        runOnSlaves(index) { this.setNeutralMode(mode) }
    }

    fun setInverted(inverted: Boolean, index: Int = -1) {
        runOnMaster(index) { this.inverted = inverted }
        runOnSlaves(index) { this.inverted = inverted }
    }

    fun enableVoltageCompensation(enable: Boolean) {
        master.enableVoltageCompensation(enable)
    }

    fun stop(index: Int = 0) {
        runOnMaster(index) { neutralOutput() }
        runOnSlaves(index) { neutralOutput() }
    }
}