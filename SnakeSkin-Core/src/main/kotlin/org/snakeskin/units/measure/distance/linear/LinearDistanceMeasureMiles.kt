package org.snakeskin.units.measure.distance.linear

import org.snakeskin.units.LinearDistanceUnit

/**
 * @author Cameron Earle
 * @version 7/15/2018
 *
 * TODO Class to be inlined in Kotlin 1.3
 */
/*inline*/ class LinearDistanceMeasureMiles(override val value: Double): LinearDistanceMeasure {
    companion object {
        const val MILES_TO_CENTIMETERS = 160934.0
        const val MILES_TO_METERS = 1609.34
        const val MILES_TO_INCHES = 63360
        const val MILES_TO_FEET = 5280
    }

    override val unit: LinearDistanceUnit
        get() = LinearDistanceUnit.MILES

    override fun toUnit(unit: LinearDistanceUnit): LinearDistanceMeasure {
        return when (unit) {
            LinearDistanceUnit.MILES -> this
            LinearDistanceUnit.CENTIMETERS -> LinearDistanceMeasureCentimeters(value * MILES_TO_CENTIMETERS)
            LinearDistanceUnit.METERS -> LinearDistanceMeasureMeters(value * MILES_TO_METERS)
            LinearDistanceUnit.INCHES -> LinearDistanceMeasureInches(value * MILES_TO_INCHES)
            LinearDistanceUnit.FEET -> LinearDistanceMeasureFeet(value * MILES_TO_FEET)
        }
    }
}