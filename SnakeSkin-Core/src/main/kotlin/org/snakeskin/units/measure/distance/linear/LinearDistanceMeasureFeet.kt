package org.snakeskin.units.measure.distance.linear

import org.snakeskin.units.LinearDistanceUnit

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 */
inline class LinearDistanceMeasureFeet(override val value: Double): LinearDistanceMeasure {
    companion object {
        const val FEET_TO_INCHES = 12.0
        const val FEET_TO_METERS = 0.3048
        const val FEET_TO_CENTIMETERS = 30.48
        const val FEET_TO_MILES = 0.000189394
    }

    override val unit: LinearDistanceUnit
        get() = LinearDistanceUnit.Standard.FEET

    override fun toUnit(unit: LinearDistanceUnit): LinearDistanceMeasure {
        return when (unit) {
            LinearDistanceUnit.Standard.FEET -> this
            LinearDistanceUnit.Standard.INCHES -> LinearDistanceMeasureInches(value * FEET_TO_INCHES)
            LinearDistanceUnit.Standard.METERS -> LinearDistanceMeasureMeters(value * FEET_TO_METERS)
            LinearDistanceUnit.Standard.CENTIMETERS -> LinearDistanceMeasureCentimeters(value * FEET_TO_CENTIMETERS)
            LinearDistanceUnit.Standard.MILES -> LinearDistanceMeasureMiles(value * FEET_TO_MILES)
            else -> unit.convert(this)
        }
    }

    override fun toString(): String {
        return "$value ft"
    }
}