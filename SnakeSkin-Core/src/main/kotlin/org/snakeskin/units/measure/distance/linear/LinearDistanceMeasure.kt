package org.snakeskin.units.measure.distance.linear

import org.snakeskin.units.LinearDistanceUnit
import org.snakeskin.units.measure.Measure
import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasure
import org.snakeskin.units.measure.velocity.linear.LinearVelocityMeasure
import org.snakeskin.units.measure.velocity.linear.LinearVelocityMeasureInchesPerSecond

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 */
interface LinearDistanceMeasure: Measure<LinearDistanceUnit, LinearDistanceMeasure> {
    fun toAngularDistance(diameter: Double): AngularDistanceMeasure {
        TODO()
    }

    fun toLinearVelocity(other: LinearDistanceMeasure, dt: Double): LinearVelocityMeasure {
        val thisNative = this.inUnit(LinearDistanceUnit.INCHES)
        val otherNative = other.inUnit(LinearDistanceUnit.INCHES)
        return LinearVelocityMeasureInchesPerSecond((otherNative.value - thisNative.value) / dt)
    }
}