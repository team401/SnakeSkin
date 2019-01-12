package org.snakeskin.component

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.NeutralMode
import com.ctre.phoenix.sensors.PigeonIMU
import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasure
import org.snakeskin.units.measure.distance.linear.LinearDistanceMeasure

/**
 * @author Cameron Earle
 * @version 7/21/2018
 *
 */
interface TankDrivetrain {
    var wheelRadius: LinearDistanceMeasure
    var wheelbase: LinearDistanceMeasure

    val left: Gearbox
    val right: Gearbox
    val imu: PigeonIMU

    fun tank(mode: ControlMode, left: Double, right: Double)
    fun arcade(mode: ControlMode, translation: Double, rotation: Double)

    fun setCurrentLimit(continuousCurrent: Int, peakCurrent: Int = 0, peakDuration: Int = 0, timeout: Int = 0)
    fun setOutputLimits(peakForward: Double = 1.0, peakReverse: Double = 1.0, nominalForward: Double = 1.0, nominalReverse: Double = 1.0, timeout: Int = 0)

    fun setRampRate(closedLoop: Double, openLoop: Double, timeout: Int = 0)
    fun setNeutralMode(mode: NeutralMode)

    fun getYaw(): AngularDistanceMeasure
    fun getPitch(): AngularDistanceMeasure
    fun getRoll(): AngularDistanceMeasure

    fun setYaw(yaw: AngularDistanceMeasure, timeout: Int = 0)

    fun enableVoltageCompensation(enable: Boolean)

    fun stop()
}