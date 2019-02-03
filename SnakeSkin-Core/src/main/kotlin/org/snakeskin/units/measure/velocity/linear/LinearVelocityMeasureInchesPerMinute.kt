package org.snakeskin.units.measure.velocity.linear

import org.snakeskin.units.LinearVelocityUnit
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasure

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 */
class LinearVelocityMeasureInchesPerMinute(override val value: Double): LinearVelocityMeasure {
    companion object {
        const val INCHES_PER_MINUTE_TO_INCHES_PER_SECOND = 0.016666667
        const val INCHES_PER_MINUTE_TO_FEET_PER_SECOND = 0.001388889
        const val INCHES_PER_MINUTE_TO_METERS_PER_SECOND = 4.23333E-4
        const val INCHES_PER_MINUTE_TO_CENTIMETERS_PER_SECOND = 0.042333333
        const val INCHES_PER_MINUTE_TO_FEET_PER_MINUTE = 0.083333333
        const val INCHES_PER_MINUTE_TO_METERS_PER_MINUTE = 0.0254
        const val INCHES_PER_MINUTE_TO_CENTIMETERS_PER_MINUTE = 2.54
        const val INCHES_PER_MINUTE_TO_MILES_PER_HOUR = 9.4697E-4
    }

    override val unit: LinearVelocityUnit
        get() = LinearVelocityUnit.Standard.INCHES_PER_MINUTE

    override fun toUnit(unit: LinearVelocityUnit): LinearVelocityMeasure {
        return when (unit) {
            LinearVelocityUnit.Standard.INCHES_PER_MINUTE -> this
            LinearVelocityUnit.Standard.INCHES_PER_SECOND -> LinearVelocityMeasureInchesPerSecond(value * INCHES_PER_MINUTE_TO_INCHES_PER_SECOND)
            LinearVelocityUnit.Standard.FEET_PER_SECOND -> LinearVelocityMeasureFeetPerSecond(value * INCHES_PER_MINUTE_TO_FEET_PER_SECOND)
            LinearVelocityUnit.Standard.METERS_PER_SECOND -> LinearVelocityMeasureMetersPerSecond(value * INCHES_PER_MINUTE_TO_METERS_PER_SECOND)
            LinearVelocityUnit.Standard.CENTIMETERS_PER_SECOND -> LinearVelocityMeasureCentimetersPerSecond(value * INCHES_PER_MINUTE_TO_CENTIMETERS_PER_SECOND)
            LinearVelocityUnit.Standard.FEET_PER_MINUTE -> LinearVelocityMeasureFeetPerMinute(value * INCHES_PER_MINUTE_TO_FEET_PER_MINUTE)
            LinearVelocityUnit.Standard.METERS_PER_MINUTE -> LinearVelocityMeasureMetersPerMinute(value * INCHES_PER_MINUTE_TO_METERS_PER_MINUTE)
            LinearVelocityUnit.Standard.CENTIMETERS_PER_MINUTE -> LinearVelocityMeasureCentimetersPerMinute(value * INCHES_PER_MINUTE_TO_CENTIMETERS_PER_MINUTE)
            LinearVelocityUnit.Standard.MILES_PER_HOUR -> LinearVelocityMeasureMilesPerHour(value * INCHES_PER_MINUTE_TO_MILES_PER_HOUR)
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
        return "$value in/min"
    }
}
