package org.snakeskin.component.impl

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.NeutralMode
import com.ctre.phoenix.sensors.PigeonIMU
import org.snakeskin.component.Gearbox
import org.snakeskin.component.TankDrivetrain
import org.snakeskin.template.TankDrivetrainGeometryTemplate
import org.snakeskin.units.AngularDistanceUnit
import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasure
import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasureDegrees
import org.snakeskin.units.measure.distance.linear.LinearDistanceMeasure

/**
 * @author Cameron Earle
 * @version 7/21/2018
 *
 */
class SmartTankDrivetrain(
        geometryTemplate: TankDrivetrainGeometryTemplate,
        override val left: Gearbox,
        override val right: Gearbox,
        override val imu: PigeonIMU
): TankDrivetrain {
    override val wheelbase = geometryTemplate.wheelbase
    override val wheelRadius = geometryTemplate.wheelRadius

    private val imuData = DoubleArray(3)

    override fun tank(mode: ControlMode, left: Double, right: Double) {
        this.left.set(mode, left)
        this.right.set(mode, right)
    }

    override fun arcade(mode: ControlMode, translation: Double, rotation: Double) {
        left.set(mode, translation + rotation)
        right.set(mode, translation - rotation)
    }

    override fun setCurrentLimit(continuousCurrent: Int, peakCurrent: Int, peakDuration: Int, timeout: Int) {
        left.setCurrentLimit(continuousCurrent, peakCurrent, peakDuration, timeout)
        right.setCurrentLimit(continuousCurrent, peakCurrent, peakDuration, timeout)
    }

    override fun setOutputLimits(peakForward: Double, peakReverse: Double, nominalForward: Double, nominalReverse: Double, timeout: Int) {
        left.setOutputLimits(peakForward, peakReverse, nominalForward, nominalReverse, timeout)
        right.setOutputLimits(peakForward, peakReverse, nominalForward, nominalReverse, timeout)
    }

    override fun setRampRate(closedLoop: Double, openLoop: Double, timeout: Int) {
        left.setRampRate(closedLoop, openLoop, timeout)
        right.setRampRate(closedLoop, openLoop, timeout)
    }

    override fun setNeutralMode(mode: NeutralMode) {
        left.setNeutralMode(mode)
        right.setNeutralMode(mode)
    }

    override fun getYaw(): AngularDistanceMeasure {
        imu.getYawPitchRoll(imuData)
        return AngularDistanceMeasureDegrees(imuData[0])
    }

    override fun getPitch(): AngularDistanceMeasure {
        imu.getYawPitchRoll(imuData)
        return AngularDistanceMeasureDegrees(imuData[1])
    }

    override fun getRoll(): AngularDistanceMeasure {
        imu.getYawPitchRoll(imuData)
        return AngularDistanceMeasureDegrees(imuData[2])
    }

    override fun setYaw(yaw: AngularDistanceMeasure, timeout: Int) {
        imu.setYaw(yaw.toUnit(AngularDistanceUnit.Standard.DEGREES).value * 64, timeout)
    }

    override fun enableVoltageCompensation(enable: Boolean) {
        left.enableVoltageCompensation(enable)
        right.enableVoltageCompensation(enable)
    }

    override fun stop() {
        tank(ControlMode.PercentOutput, 0.0, 0.0)
    }
}