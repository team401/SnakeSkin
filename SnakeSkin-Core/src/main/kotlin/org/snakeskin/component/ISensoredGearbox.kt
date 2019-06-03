package org.snakeskin.component

import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRadians
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRadiansPerSecond

/**
 * @author Cameron Earle
 * @version 1/9/2019
 *
 */
interface ISensoredGearbox: IGearbox {
    /**
     * The current angular position of the gearbox.
     */
    fun getPosition(): AngularDistanceMeasureRadians

    /*
     * The current angular velocity of the gearbox.
     */
    fun getVelocity(): AngularVelocityMeasureRadiansPerSecond

    /**
     * Sets the position of the sensor to the specified position.
     * Note: Implementations may not honor the distance passed, and may
     * instead set the distance to 0
     */
    fun setPosition(position: AngularDistanceMeasureRadians)
}