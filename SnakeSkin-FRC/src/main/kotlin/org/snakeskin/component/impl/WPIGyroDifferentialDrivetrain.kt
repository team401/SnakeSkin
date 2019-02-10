package org.snakeskin.component.impl

import edu.wpi.first.wpilibj.interfaces.Gyro
import org.snakeskin.component.IGearbox
import org.snakeskin.component.IDifferentialDrivetrain
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
open class WPIGyroDifferentialDrivetrain<G: IGearbox>(left: G, right: G, val gyro: Gyro, geometry: TankDrivetrainGeometryTemplate):
        IYawSensoredDifferentialDrivetrain<G>, IDifferentialDrivetrain<G> by DifferentialDrivetrain(left, right, geometry) {
    override fun getYaw(): AngularDistanceMeasureRadians {
        return AngularDistanceMeasureDegrees(gyro.angle).toRadians()
    }

    override fun getYawRate(): AngularVelocityMeasureRadiansPerSecond {
        return AngularVelocityMeasureDegreesPerSecond(gyro.rate).toRadiansPerSecond()
    }

    /**
     * This implementation does not honor the value passed in for yaw, and instead resets the angle to 0
     */
    override fun setYaw(yaw: AngularDistanceMeasureRadians) {
        gyro.reset()
    }
}