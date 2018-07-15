package org.snakeskin.units.measure.distance.linear

import org.snakeskin.units.LinearDistanceUnit

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 * TODO Class to be inlined in Kotlin 1.3
 */
/*inline*/ class LinearDistanceMeasureFeet(override val value: Double): LinearDistanceMeasure {
    companion object {
        const val FEET_TO_INCHES = 12.0
        const val FEET_TO_METERS = 0.3048
        const val FEET_TO_CENTIMETERS = 30.48
        const val FEET_TO_MILES = 0.000189394
    }

    override val unit: LinearDistanceUnit
        get() = LinearDistanceUnit.FEET

    override fun toUnit(unit: LinearDistanceUnit): LinearDistanceMeasure {
        return when (unit) {
            LinearDistanceUnit.FEET -> this
            LinearDistanceUnit.INCHES -> LinearDistanceMeasureInches(value * FEET_TO_INCHES)
            LinearDistanceUnit.METERS -> LinearDistanceMeasureMeters(value * FEET_TO_METERS)
            LinearDistanceUnit.CENTIMETERS -> LinearDistanceMeasureCentimeters(value * FEET_TO_CENTIMETERS)
            LinearDistanceUnit.MILES -> LinearDistanceMeasureMiles(value * FEET_TO_MILES)
        }
    }
}