package org.snakeskin.units.measure.velocity.linear

import org.snakeskin.units.LinearVelocityUnit
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasure

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 */
inline class LinearVelocityMeasureFeetPerMinute(override val value: Double): LinearVelocityMeasure {
    companion object {
        const val FEET_PER_MINUTE_TO_INCHES_PER_SECOND = 0.2
        const val FEET_PER_MINUTE_TO_FEET_PER_SECOND = 0.016666667
        const val FEET_PER_MINUTE_TO_METERS_PER_SECOND = 0.00508
        const val FEET_PER_MINUTE_TO_CENTIMETERS_PER_SECOND = 0.508
        const val FEET_PER_MINUTE_TO_INCHES_PER_MINUTE = 12.0
        const val FEET_PER_MINUTE_TO_METERS_PER_MINUTE = 0.3048
        const val FEET_PER_MINUTE_TO_CENTIMETERS_PER_MINUTE = 30.48
        const val FEET_PER_MINUTE_TO_MILES_PER_HOUR = 0.011363636
    }

    override val unit: LinearVelocityUnit
        get() = LinearVelocityUnit.Standard.FEET_PER_MINUTE

    override fun toUnit(unit: LinearVelocityUnit): LinearVelocityMeasure {
        return when (unit) {
            LinearVelocityUnit.Standard.FEET_PER_MINUTE -> this
            LinearVelocityUnit.Standard.INCHES_PER_SECOND -> LinearVelocityMeasureInchesPerSecond(value * FEET_PER_MINUTE_TO_INCHES_PER_SECOND)
            LinearVelocityUnit.Standard.FEET_PER_SECOND -> LinearVelocityMeasureFeetPerSecond(value * FEET_PER_MINUTE_TO_FEET_PER_SECOND)
            LinearVelocityUnit.Standard.METERS_PER_SECOND -> LinearVelocityMeasureMetersPerSecond(value * FEET_PER_MINUTE_TO_METERS_PER_SECOND)
            LinearVelocityUnit.Standard.CENTIMETERS_PER_SECOND -> LinearVelocityMeasureCentimetersPerSecond(value * FEET_PER_MINUTE_TO_CENTIMETERS_PER_SECOND)
            LinearVelocityUnit.Standard.INCHES_PER_MINUTE -> LinearVelocityMeasureInchesPerMinute(value * FEET_PER_MINUTE_TO_INCHES_PER_MINUTE)
            LinearVelocityUnit.Standard.METERS_PER_MINUTE -> LinearVelocityMeasureMetersPerMinute(value * FEET_PER_MINUTE_TO_METERS_PER_MINUTE)
            LinearVelocityUnit.Standard.CENTIMETERS_PER_MINUTE -> LinearVelocityMeasureCentimetersPerMinute(value * FEET_PER_MINUTE_TO_CENTIMETERS_PER_MINUTE)
            LinearVelocityUnit.Standard.MILES_PER_HOUR -> LinearVelocityMeasureMilesPerHour(value * FEET_PER_MINUTE_TO_MILES_PER_HOUR)
            else -> unit.convert(this)
        }
    }

    override fun toString(): String {
        return "$value ft/min"
    }
}
