package org.snakeskin.component.impl

import com.ctre.phoenix.sensors.PigeonIMU
import edu.wpi.first.wpilibj.Encoder
import org.snakeskin.component.IDifferentialDrivetrain
import org.snakeskin.component.IGearbox
import org.snakeskin.component.ISensoredGearbox
import org.snakeskin.component.IYawSensoredDifferentialDrivetrain
import org.snakeskin.component.template.TankDrivetrainGeometryTemplate
import org.snakeskin.units.AngularDistanceUnit
import org.snakeskin.units.Inches
import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasure
import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasureDegrees
import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasureRadians
import org.snakeskin.units.measure.distance.linear.LinearDistanceMeasure
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasureDegreesPerSecond
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasureRadiansPerSecond

/**
 * @author Cameron Earle
 * @version 1/26/2019
 *
 */
open class PigeonIMUDifferentialDrivetrain<G: IGearbox>(left: G, right: G, val imu: PigeonIMU, geometry: TankDrivetrainGeometryTemplate):
        IYawSensoredDifferentialDrivetrain<G>, IDifferentialDrivetrain<G> by DifferentialDrivetrain(left, right, geometry) {

    private val ypr = DoubleArray(3)
    private val xyzDps = DoubleArray(3)

    override fun getYawRadians(): Double {
        imu.getYawPitchRoll(ypr)
        return AngularDistanceMeasureDegrees.DEGREES_TO_RADIANS * ypr[0]
    }

    override fun getYawRateRadiansPerSecond(): Double {
        imu.getRawGyro(xyzDps)
        return AngularVelocityMeasureDegreesPerSecond.DEGREES_PER_SECOND_TO_RADIANS_PER_SECOND * xyzDps[2]
    }

    override fun getYaw(): AngularDistanceMeasureRadians {
        return AngularDistanceMeasureRadians(getYawRadians())
    }

    override fun getYawRate(): AngularVelocityMeasureRadiansPerSecond {
        return AngularVelocityMeasureRadiansPerSecond(getYawRateRadiansPerSecond())
    }

    override fun setYaw(yaw: AngularDistanceMeasure) {
        imu.setYaw(yaw.toUnit(AngularDistanceUnit.Standard.DEGREES).value)
    }
}