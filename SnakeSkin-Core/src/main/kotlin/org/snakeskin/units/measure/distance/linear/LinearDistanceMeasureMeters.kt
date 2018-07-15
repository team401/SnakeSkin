package org.snakeskin.units.measure.distance.linear

import org.snakeskin.units.LinearDistanceUnit

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 * TODO Class to be inlined in Kotlin 1.3
 */
/*inline*/ class LinearDistanceMeasureMeters(override val value: Double): LinearDistanceMeasure {
    companion object {
        const val METERS_TO_CENTIMETERS = 100.0
        const val METERS_TO_INCHES = 39.3701
        const val METERS_TO_FEET = 3.28084
        const val METERS_TO_MILES = 0.000621371
    }

    override val unit: LinearDistanceUnit
        get() = LinearDistanceUnit.METERS

    override fun toUnit(unit: LinearDistanceUnit): LinearDistanceMeasure {
        return when (unit) {
            LinearDistanceUnit.METERS -> this
            LinearDistanceUnit.CENTIMETERS -> LinearDistanceMeasureCentimeters(value * METERS_TO_CENTIMETERS)
            LinearDistanceUnit.INCHES -> LinearDistanceMeasureInches(value * METERS_TO_INCHES)
            LinearDistanceUnit.FEET -> LinearDistanceMeasureFeet(value * METERS_TO_FEET)
            LinearDistanceUnit.MILES -> LinearDistanceMeasureMiles(value * METERS_TO_MILES)
        }
    }
}