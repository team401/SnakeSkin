package org.snakeskin.component.impl

import com.ctre.phoenix.sensors.PigeonIMU
import org.snakeskin.component.IDifferentialDrivetrain
import org.snakeskin.component.IGearbox
import org.snakeskin.component.IYawSensoredDifferentialDrivetrain
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureDegrees
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRadians
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureDegreesPerSecond
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRadiansPerSecond
import org.snakeskin.template.TankDrivetrainGeometryTemplate

/**
 * @author Cameron Earle
 * @version 1/26/2019
 *
 */
@Deprecated("Replaced with new component system")
open class PigeonIMUDifferentialDrivetrain<G: IGearbox>(left: G, right: G, val imu: PigeonIMU, geometry: TankDrivetrainGeometryTemplate):
        IYawSensoredDifferentialDrivetrain<G>, IDifferentialDrivetrain<G> by DifferentialDrivetrain(left, right, geometry) {

    private val ypr = DoubleArray(3)
    private val xyzDps = DoubleArray(3)

    override fun getYaw(): AngularDistanceMeasureRadians {
        imu.getYawPitchRoll(ypr)
        return AngularDistanceMeasureDegrees(ypr[0]).toRadians()
    }

    override fun getYawRate(): AngularVelocityMeasureRadiansPerSecond {
        imu.getRawGyro(xyzDps)
        return AngularVelocityMeasureDegreesPerSecond(xyzDps[2]).toRadiansPerSecond()
    }

    override fun setYaw(yaw: AngularDistanceMeasureRadians) {
        imu.setYaw(yaw.toDegrees().value)
    }
}