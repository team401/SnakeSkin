package org.snakeskin.units.measure.distance.linear

import org.snakeskin.units.LinearDistanceUnit

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 * TODO Class to be inlined in Kotlin 1.3
 */
/*inline*/ class LinearDistanceMeasureInches(override val value: Double): LinearDistanceMeasure {
    companion object {
        const val INCHES_TO_FEET = 1/12.0
        const val INCHES_TO_CENTIMETERS = 2.54
        const val INCHES_TO_METERS = 0.0254
        const val INCHES_TO_MILES = 1.57828e-5
    }

    override val unit: LinearDistanceUnit
        get() = LinearDistanceUnit.INCHES

    override fun toUnit(unit: LinearDistanceUnit): LinearDistanceMeasure {
        return when (unit) {
            LinearDistanceUnit.INCHES -> this
            LinearDistanceUnit.FEET -> LinearDistanceMeasureFeet(value * INCHES_TO_FEET)
            LinearDistanceUnit.CENTIMETERS -> LinearDistanceMeasureCentimeters(value * INCHES_TO_CENTIMETERS)
            LinearDistanceUnit.METERS -> LinearDistanceMeasureMeters(value * INCHES_TO_METERS)
            LinearDistanceUnit.MILES -> LinearDistanceMeasureMiles(value * INCHES_TO_MILES)
        }
    }
}