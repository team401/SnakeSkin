package org.snakeskin.component.impl

import edu.wpi.first.wpilibj.interfaces.Gyro
import org.snakeskin.component.IGearbox
import org.snakeskin.component.IDifferentialDrivetrain
import org.snakeskin.component.IYawSensoredDifferentialDrivetrain
import org.snakeskin.component.template.TankDrivetrainGeometryTemplate
import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasure
import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasureDegrees
import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasureRadians
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasureDegreesPerSecond
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasureRadiansPerSecond

/**
 * @author Cameron Earle
 * @version 1/26/2019
 *
 */
open class WPIGyroDifferentialDrivetrain<G: IGearbox>(left: G, right: G, val gyro: Gyro, geometry: TankDrivetrainGeometryTemplate):
        IYawSensoredDifferentialDrivetrain<G>, IDifferentialDrivetrain<G> by DifferentialDrivetrain(left, right, geometry) {
    override fun getYawRadians(): Double {
        return AngularDistanceMeasureDegrees.DEGREES_TO_RADIANS * gyro.angle
    }

    override fun getYawRateRadiansPerSecond(): Double {
        return AngularVelocityMeasureDegreesPerSecond.DEGREES_PER_SECOND_TO_RADIANS_PER_SECOND * gyro.rate
    }

    override fun getYaw(): AngularDistanceMeasureRadians {
        return AngularDistanceMeasureRadians(getYawRadians())
    }

    override fun getYawRate(): AngularVelocityMeasureRadiansPerSecond {
        return AngularVelocityMeasureRadiansPerSecond(getYawRateRadiansPerSecond())
    }

    /**
     * This implementation does not honor the value passed in for yaw, and instead resets the angle to 0
     */
    override fun setYaw(yaw: AngularDistanceMeasure) {
        gyro.reset()
    }
}