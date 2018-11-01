package org.snakeskin.units.measure.velocity.linear

import org.snakeskin.units.LinearVelocityUnit
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasure

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 */
inline class LinearVelocityMeasureMilesPerHour(override val value: Double): LinearVelocityMeasure {
    companion object {
        const val MILES_PER_HOUR_TO_INCHES_PER_SECOND = 17.6
        const val MILES_PER_HOUR_TO_FEET_PER_SECOND = 1.466666667
        const val MILES_PER_HOUR_TO_METERS_PER_SECOND = 0.44704
        const val MILES_PER_HOUR_TO_CENTIMETERS_PER_SECOND = 44.704
        const val MILES_PER_HOUR_TO_INCHES_PER_MINUTE = 1056.0
        const val MILES_PER_HOUR_TO_FEET_PER_MINUTE = 88.0
        const val MILES_PER_HOUR_TO_METERS_PER_MINUTE = 26.8224
        const val MILES_PER_HOUR_TO_CENTIMETERS_PER_MINUTE = 2682.24
    }

    override val unit: LinearVelocityUnit
        get() = LinearVelocityUnit.Standard.MILES_PER_HOUR

    override fun toUnit(unit: LinearVelocityUnit): LinearVelocityMeasure {
        return when (unit) {
            LinearVelocityUnit.Standard.MILES_PER_HOUR -> this
            LinearVelocityUnit.Standard.INCHES_PER_SECOND -> LinearVelocityMeasureInchesPerSecond(value * MILES_PER_HOUR_TO_INCHES_PER_SECOND)
            LinearVelocityUnit.Standard.FEET_PER_SECOND -> LinearVelocityMeasureFeetPerSecond(value * MILES_PER_HOUR_TO_FEET_PER_SECOND)
            LinearVelocityUnit.Standard.METERS_PER_SECOND -> LinearVelocityMeasureMetersPerSecond(value * MILES_PER_HOUR_TO_METERS_PER_SECOND)
            LinearVelocityUnit.Standard.CENTIMETERS_PER_SECOND -> LinearVelocityMeasureCentimetersPerSecond(value * MILES_PER_HOUR_TO_CENTIMETERS_PER_SECOND)
            LinearVelocityUnit.Standard.INCHES_PER_MINUTE -> LinearVelocityMeasureInchesPerMinute(value * MILES_PER_HOUR_TO_INCHES_PER_MINUTE)
            LinearVelocityUnit.Standard.FEET_PER_MINUTE -> LinearVelocityMeasureFeetPerMinute(value * MILES_PER_HOUR_TO_FEET_PER_MINUTE)
            LinearVelocityUnit.Standard.METERS_PER_MINUTE -> LinearVelocityMeasureMetersPerMinute(value * MILES_PER_HOUR_TO_METERS_PER_MINUTE)
            LinearVelocityUnit.Standard.CENTIMETERS_PER_MINUTE -> LinearVelocityMeasureCentimetersPerMinute(value * MILES_PER_HOUR_TO_CENTIMETERS_PER_MINUTE)
            else -> unit.convert(this)
        }
    }
}
