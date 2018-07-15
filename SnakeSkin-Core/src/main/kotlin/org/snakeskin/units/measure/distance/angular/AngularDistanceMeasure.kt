package org.snakeskin.units.measure.distance.angular

import org.snakeskin.units.AngularDistanceUnit
import org.snakeskin.units.measure.Measure
import org.snakeskin.units.measure.distance.linear.LinearDistanceMeasure
import org.snakeskin.units.measure.time.TimeMeasure
import org.snakeskin.units.AngularVelocityUnit

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 */
interface AngularDistanceMeasure: Measure<AngularDistanceUnit, AngularDistanceMeasure> {

    /**
     * Produces a linear distance from this angle given a radius
     *
     * Calculation is done in radians, output unit is the unit of the radius
     */
    fun toLinearDistance(radius: LinearDistanceMeasure): LinearDistanceMeasure {
        return LinearDistanceMeasure.create(
                radius.value * this.toUnit(AngularDistanceUnit.RADIANS).value,
                radius.unit
        )
    }

    /**
     * Produces an angular velocity from a second distance measurement
     * The output unit is (this distance unit / dt time unit)
     *
     * Note that not all possible distance/time combinations exist,
     * so be sure to choose your dt unit carefully (for example,
     * minutes can only be used for revolutions, hours and milliseconds cannot be used)
     *
     * @see AngularVelocityUnit for possible combinations
     */
    fun toAngularVelocity(dt: TimeMeasure) {

    }

    companion object {
        fun create(value: Double, unit: AngularDistanceUnit): AngularDistanceMeasure {
            return when (unit) {
                AngularDistanceUnit.REVOLUTIONS -> AngularDistanceMeasureRevolutions(value)
                AngularDistanceUnit.RADIANS -> AngularDistanceMeasureRadians(value)
                AngularDistanceUnit.DEGREES -> AngularDistanceMeasureDegrees(value)
            }
        }
    }
}