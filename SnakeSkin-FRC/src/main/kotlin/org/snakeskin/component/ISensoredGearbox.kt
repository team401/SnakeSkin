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
     * Resets the position of the gearbox to 0
     */
    fun resetPosition()

    /**
     * Sets the angle travelled per tick of the encoder.
     */
    fun setDistancePerTick(dpt: AngularDistanceMeasure)
}