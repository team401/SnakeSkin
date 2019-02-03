package org.snakeskin.units.measure.velocity.linear

import org.snakeskin.units.LinearVelocityUnit
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasure

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 */
class LinearVelocityMeasureCentimetersPerMinute(override val value: Double): LinearVelocityMeasure {
    companion object {
        const val CENTIMETERS_PER_MINUTE_TO_INCHES_PER_SECOND = 0.00656168
        const val CENTIMETERS_PER_MINUTE_TO_FEET_PER_SECOND = 5.46807E-4
        const val CENTIMETERS_PER_MINUTE_TO_METERS_PER_SECOND = 1.66667E-4
        const val CENTIMETERS_PER_MINUTE_TO_CENTIMETERS_PER_SECOND = 0.016666667
        const val CENTIMETERS_PER_MINUTE_TO_INCHES_PER_MINUTE = 0.393700787
        const val CENTIMETERS_PER_MINUTE_TO_FEET_PER_MINUTE = 0.032808399
        const val CENTIMETERS_PER_MINUTE_TO_METERS_PER_MINUTE = 0.01
        const val CENTIMETERS_PER_MINUTE_TO_MILES_PER_HOUR = 3.72823E-4
    }

    override val unit: LinearVelocityUnit
        get() = LinearVelocityUnit.Standard.CENTIMETERS_PER_MINUTE

    override fun toUnit(unit: LinearVelocityUnit): LinearVelocityMeasure {
        return when (unit) {
            LinearVelocityUnit.Standard.CENTIMETERS_PER_MINUTE -> this
            LinearVelocityUnit.Standard.INCHES_PER_SECOND -> LinearVelocityMeasureInchesPerSecond(value * CENTIMETERS_PER_MINUTE_TO_INCHES_PER_SECOND)
            LinearVelocityUnit.Standard.FEET_PER_SECOND -> LinearVelocityMeasureFeetPerSecond(value * CENTIMETERS_PER_MINUTE_TO_FEET_PER_SECOND)
            LinearVelocityUnit.Standard.METERS_PER_SECOND -> LinearVelocityMeasureMetersPerSecond(value * CENTIMETERS_PER_MINUTE_TO_METERS_PER_SECOND)
            LinearVelocityUnit.Standard.CENTIMETERS_PER_SECOND -> LinearVelocityMeasureCentimetersPerSecond(value * CENTIMETERS_PER_MINUTE_TO_CENTIMETERS_PER_SECOND)
            LinearVelocityUnit.Standard.INCHES_PER_MINUTE -> LinearVelocityMeasureInchesPerMinute(value * CENTIMETERS_PER_MINUTE_TO_INCHES_PER_MINUTE)
            LinearVelocityUnit.Standard.FEET_PER_MINUTE -> LinearVelocityMeasureFeetPerMinute(value * CENTIMETERS_PER_MINUTE_TO_FEET_PER_MINUTE)
            LinearVelocityUnit.Standard.METERS_PER_MINUTE -> LinearVelocityMeasureMetersPerMinute(value * CENTIMETERS_PER_MINUTE_TO_METERS_PER_MINUTE)
            LinearVelocityUnit.Standard.MILES_PER_HOUR -> LinearVelocityMeasureMilesPerHour(value * CENTIMETERS_PER_MINUTE_TO_MILES_PER_HOUR)
            else -> unit.convert(this)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other is LinearVelocityMeasure) {
            val converted = other.toUnit(unit).value
            return converted == value
        }
        return false
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun toString(): String {
        return "$value cm/min"
    }
}
