package org.snakeskin.component

import com.ctre.phoenix.MotorControl.ControlMode
import com.ctre.phoenix.MotorControl.NeutralMode
import com.ctre.phoenix.Sensors.PigeonIMU
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

class TankDrivetrain(val wheelRadius: Double, val wheelbase: Double) {
    lateinit var left: Gearbox; private set
    lateinit var right: Gearbox; private set
    lateinit var imu: PigeonIMU; private set

    fun init(left: Gearbox, right: Gearbox, imu: PigeonIMU, invertLeft: Boolean = false, invertRight: Boolean = false) {
        this.left = left
        this.right = right
        this.imu = imu

        this.left.setInverted(invertLeft)
        this.right.setInverted(invertRight)
    }

    fun arcade(mode: ControlMode, translation: Double, rotation: Double) {
        left.set(mode, translation + rotation)
        right.set(mode, translation - rotation)
    }

    fun tank(mode: ControlMode, left: Double, right: Double) {
        this.left.set(mode, left)
        this.right.set(mode, right)
    }

    fun setCurrentLimit(continuousCurrent: Int, peakCurrent: Int = 0, peakDuration: Int = 0, timeout: Int = CTREConstants.CONFIG_TIMEOUT) {
        left.setCurrentLimit(continuousCurrent, peakCurrent, peakDuration, timeout)
        right.setCurrentLimit(continuousCurrent, peakCurrent, peakDuration, timeout)
    }

    fun setRampRate(closedLoop: Double, openLoop: Double, timeout: Int = CTREConstants.CONFIG_TIMEOUT) {
        left.setRampRate(closedLoop, openLoop, timeout)
        right.setRampRate(closedLoop, openLoop, timeout)
    }

    fun setNeutralMode(mode: NeutralMode) {
        left.setNeutralMode(mode)
        right.setNeutralMode(mode)
    }

    fun stop() {
        left.stop()
        right.stop()
    }

    fun getDistance() = (left.getPosition() + right.getPosition()) * wheelRadius * Math.PI
    fun getVelocity() = (left.getVelocity() + right.getVelocity()) * wheelRadius * Math.PI
    fun getYaw() = imu.yawPitchRoll[0]

    fun setPosition(position: Int) {
        left.setPosition(position)
        right.setPosition(position)
    }

    fun setYaw(yaw: Double) {
        imu.setYaw(yaw)
    }

    fun reset() {
        setPosition(0)
        setYaw(0.0)
    }


}