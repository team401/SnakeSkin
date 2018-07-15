package org.snakeskin.units.measure.velocity.linear

import org.snakeskin.units.LinearVelocityUnit
import org.snakeskin.units.measure.Measure
import org.snakeskin.units.measure.distance.linear.LinearDistanceMeasure
import org.snakeskin.units.measure.distance.linear.LinearDistanceMeasureInches
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasure

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 */
interface LinearVelocityMeasure: Measure<LinearVelocityUnit, LinearVelocityMeasure> {
    fun toAngularVelocity(diameter: Double): AngularVelocityMeasure

    fun toLinearDistance(dt: Double): LinearDistanceMeasure {
        val thisNative = this.inUnit(LinearVelocityUnit.INCHES_PER_SECOND)
        return LinearDistanceMeasureInches(thisNative.value * dt)
    }
}