package org.snakeskin.component

import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasure
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasure

/**
 * @author Cameron Earle
 * @version 1/26/2019
 *
 */
interface IYawSensoredDifferentialDrivetrain<out G: IGearbox>: IDifferentialDrivetrain<G> {
    /**
     * Gets the yaw of the drivetrain, as measured by a properly aligned sensor.
     */
    fun getYaw(): AngularDistanceMeasure

    /**
     * Gets the yaw of the drivetrain in radians, as measured by a properly aligned sensor.
     * Avoids creating unit objects in high quantities
     */
    fun getYawRadians(): Double

    /**
     * Gets the rate of change of the yaw of the drivetrain, as measured by a properly aligned sensor.
     */
    fun getYawRate(): AngularVelocityMeasure

    /**
     * Gets the rate of change of the yaw of the drivetrain in radians per second, as measured by a properly aligned sensor.
     * Avoids creating unit objects in high quantities
     */
    fun getYawRateRadiansPerSecond(): Double

    /**
     * Sets the yaw to the specified value.
     * Note: Implementations may not honor the value passed in, and may instead just set the yaw to 0
     */
    fun setYaw(yaw: AngularDistanceMeasure)
}