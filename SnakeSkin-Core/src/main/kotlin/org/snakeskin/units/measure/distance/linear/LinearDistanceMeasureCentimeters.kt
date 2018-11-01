package org.snakeskin.units.measure.distance.linear

import org.snakeskin.units.LinearDistanceUnit
import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasure

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 */
class LinearDistanceMeasureCentimeters(override val value: Double): LinearDistanceMeasure {
    companion object {
        const val CENTIMETERS_TO_METERS = 0.01
        const val CENTIMETERS_TO_INCHES = 0.393701
        const val CENTIMETERS_TO_FEET = 0.0328084
        const val CENTIMETERS_TO_MILES = 6.21371e-6
    }

    override val unit: LinearDistanceUnit
        get() = LinearDistanceUnit.Standard.CENTIMETERS

    override fun toUnit(unit: LinearDistanceUnit): LinearDistanceMeasure {
        return when (unit) {
            LinearDistanceUnit.Standard.CENTIMETERS -> this
            LinearDistanceUnit.Standard.METERS -> LinearDistanceMeasureMeters(value * CENTIMETERS_TO_METERS)
            LinearDistanceUnit.Standard.INCHES -> LinearDistanceMeasureInches(value * CENTIMETERS_TO_INCHES)
            LinearDistanceUnit.Standard.FEET -> LinearDistanceMeasureFeet(value * CENTIMETERS_TO_FEET)
            LinearDistanceUnit.Standard.MILES -> LinearDistanceMeasureMiles(value * CENTIMETERS_TO_MILES)
            else -> unit.convert(this)
        }
    }
}