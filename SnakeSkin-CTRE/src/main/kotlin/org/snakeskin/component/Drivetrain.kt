package org.snakeskin.component

import com.ctre.phoenix.MotorControl.ControlMode
import com.ctre.phoenix.MotorControl.NeutralMode
import org.snakeskin.CTREConstants

/*
 * snakeskin - Created on 12/26/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 12/26/17
 */

interface Drivetrain {
    val wheelRadius: Double
    val wheelbase: Double
    val invertLeft: Boolean
    val invertRight: Boolean

    fun tank(mode: ControlMode, left: Double, right: Double)
    fun arcade(mode: ControlMode, translation: Double, rotation: Double)
    fun setCurrentLimit(continuousCurrent: Int, peakCurrent: Int = 0, peakDuration: Int = 0, timeout: Int = CTREConstants.CONFIG_TIMEOUT)
    fun setRampRate(closedLoop: Double, openLoop: Double, timeout: Int = CTREConstants.CONFIG_TIMEOUT)
    fun setNeutralMode(mode: NeutralMode)
    fun stop()
    fun getDistance(): Double
    fun getVelocity(): Double
    fun getYaw(): Double
    fun setPosition(position: Int)
    fun setYaw(yaw: Double)
    fun enableVoltageCompensation(enable: Boolean)
    fun zero()
}