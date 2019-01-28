package org.snakeskin.component

import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasure
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasure

/**
 * @author Cameron Earle
 * @version 1/9/2019
 *
 */
interface ISensoredGearbox: IGearbox {
    /**
     * The current angular position of the gearbox.
     */
    fun getPosition(): AngularDistanceMeasure

    /*
     * The current angular velocity of the gearbox.
     */
    fun getVelocity(): AngularVelocityMeasure

    /**
     * The current angular position of the gearbox in radians
     * Avoids creating unit objects in high quantities
     */
    fun getPositionRadians(): Double

    /**
     * The current angular velocity of the gearbox in radians per second
     * Avoids creating unit objects in high quantities
     */
    fun getVelocityRadiansPerSecond(): Double

    /**
     * Sets the position of the sensor to the specified position.
     * Note: Implementations may not honor the distance passed, and may
     * instead set the distance to 0
     */
    fun setPosition(position: AngularDistanceMeasure)

    /**
     * Sets the angle travelled per tick of the encoder.
     */
    fun setDistancePerTick(dpt: AngularDistanceMeasure)
}