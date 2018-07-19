package org.snakeskin.units.measure.velocity.linear

import org.snakeskin.units.LinearVelocityUnit
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasure

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 * TODO Class to be inlined in Kotlin 1.3
 */
/*inline*/ class LinearVelocityMeasureMetersPerSecond(override val value: Double): LinearVelocityMeasure {
    companion object {
        const val METERS_PER_SECOND_TO_INCHES_PER_SECOND = 39.37007874
        const val METERS_PER_SECOND_TO_FEET_PER_SECOND = 3.280839895
        const val METERS_PER_SECOND_TO_CENTIMETERS_PER_SECOND = 100.0
        const val METERS_PER_SECOND_TO_INCHES_PER_MINUTE = 2362.204724
        const val METERS_PER_SECOND_TO_FEET_PER_MINUTE = 196.8503937
        const val METERS_PER_SECOND_TO_METERS_PER_MINUTE = 60.0
        const val METERS_PER_SECOND_TO_CENTIMETERS_PER_MINUTE = 6000.0
        const val METERS_PER_SECOND_TO_MILES_PER_HOUR = 2.236936292
    }

    override val unit: LinearVelocityUnit
        get() = LinearVelocityUnit.Standard.METERS_PER_SECOND

    override fun toUnit(unit: LinearVelocityUnit): LinearVelocityMeasure {
        return when (unit) {
            LinearVelocityUnit.Standard.METERS_PER_SECOND -> this
            LinearVelocityUnit.Standard.INCHES_PER_SECOND -> LinearVelocityMeasureInchesPerSecond(value * METERS_PER_SECOND_TO_INCHES_PER_SECOND)
            LinearVelocityUnit.Standard.FEET_PER_SECOND -> LinearVelocityMeasureFeetPerSecond(value * METERS_PER_SECOND_TO_FEET_PER_SECOND)
            LinearVelocityUnit.Standard.CENTIMETERS_PER_SECOND -> LinearVelocityMeasureCentimetersPerSecond(value * METERS_PER_SECOND_TO_CENTIMETERS_PER_SECOND)
            LinearVelocityUnit.Standard.INCHES_PER_MINUTE -> LinearVelocityMeasureInchesPerMinute(value * METERS_PER_SECOND_TO_INCHES_PER_MINUTE)
            LinearVelocityUnit.Standard.FEET_PER_MINUTE -> LinearVelocityMeasureFeetPerMinute(value * METERS_PER_SECOND_TO_FEET_PER_MINUTE)
            LinearVelocityUnit.Standard.METERS_PER_MINUTE -> LinearVelocityMeasureMetersPerMinute(value * METERS_PER_SECOND_TO_METERS_PER_MINUTE)
            LinearVelocityUnit.Standard.CENTIMETERS_PER_MINUTE -> LinearVelocityMeasureCentimetersPerMinute(value * METERS_PER_SECOND_TO_CENTIMETERS_PER_MINUTE)
            LinearVelocityUnit.Standard.MILES_PER_HOUR -> LinearVelocityMeasureMilesPerHour(value * METERS_PER_SECOND_TO_MILES_PER_HOUR)
            else -> unit.convert(this)
        }
    }
}
