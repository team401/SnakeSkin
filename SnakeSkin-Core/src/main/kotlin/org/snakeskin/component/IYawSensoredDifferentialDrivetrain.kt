package org.snakeskin.component

import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRadians
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRadiansPerSecond

/**
 * @author Cameron Earle
 * @version 1/26/2019
 *
 */
@Deprecated("Replaced with new component system")
interface IYawSensoredDifferentialDrivetrain<out G: IGearbox>: IDifferentialDrivetrain<G> {
    /**
     * Gets the yaw of the drivetrain, as measured by a properly aligned sensor.
     */
    fun getYaw(): AngularDistanceMeasureRadians

    /**
     * Gets the rate of change of the yaw of the drivetrain, as measured by a properly aligned sensor.
     */
    fun getYawRate(): AngularVelocityMeasureRadiansPerSecond

    /**
     * Sets the yaw to the specified value.
     * Note: Implementations may not honor the value passed in, and may instead just set the yaw to 0
     */
    fun setYaw(yaw: AngularDistanceMeasureRadians)
}