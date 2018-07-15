package org.snakeskin.units.measure.velocity.linear

import org.snakeskin.units.LinearVelocityUnit
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasure

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 * TODO Class to be inlined in Kotlin 1.3
 */
/*inline*/ class LinearVelocityMeasureCentimetersPerSecond(override val value: Double): LinearVelocityMeasure {
    companion object {
        const val CENTIMETERS_PER_SECOND_TO_INCHES_PER_SECOND = 0.393700787
        const val CENTIMETERS_PER_SECOND_TO_FEET_PER_SECOND = 0.032808399
        const val CENTIMETERS_PER_SECOND_TO_METERS_PER_SECOND = 0.01
        const val CENTIMETERS_PER_SECOND_TO_INCHES_PER_MINUTE = 23.62204724
        const val CENTIMETERS_PER_SECOND_TO_FEET_PER_MINUTE = 1.968503937
        const val CENTIMETERS_PER_SECOND_TO_METERS_PER_MINUTE = 0.6
        const val CENTIMETERS_PER_SECOND_TO_CENTIMETERS_PER_MINUTE = 60.0
        const val CENTIMETERS_PER_SECOND_TO_MILES_PER_HOUR = 0.022369363
    }

    override val unit: LinearVelocityUnit
        get() = LinearVelocityUnit.CENTIMETERS_PER_SECOND

    override fun toUnit(unit: LinearVelocityUnit): LinearVelocityMeasure {
        return when (unit) {
            LinearVelocityUnit.CENTIMETERS_PER_SECOND -> this
            LinearVelocityUnit.INCHES_PER_SECOND -> LinearVelocityMeasureInchesPerSecond(value * CENTIMETERS_PER_SECOND_TO_INCHES_PER_SECOND)
            LinearVelocityUnit.FEET_PER_SECOND -> LinearVelocityMeasureFeetPerSecond(value * CENTIMETERS_PER_SECOND_TO_FEET_PER_SECOND)
            LinearVelocityUnit.METERS_PER_SECOND -> LinearVelocityMeasureMetersPerSecond(value * CENTIMETERS_PER_SECOND_TO_METERS_PER_SECOND)
            LinearVelocityUnit.INCHES_PER_MINUTE -> LinearVelocityMeasureInchesPerMinute(value * CENTIMETERS_PER_SECOND_TO_INCHES_PER_MINUTE)
            LinearVelocityUnit.FEET_PER_MINUTE -> LinearVelocityMeasureFeetPerMinute(value * CENTIMETERS_PER_SECOND_TO_FEET_PER_MINUTE)
            LinearVelocityUnit.METERS_PER_MINUTE -> LinearVelocityMeasureMetersPerMinute(value * CENTIMETERS_PER_SECOND_TO_METERS_PER_MINUTE)
            LinearVelocityUnit.CENTIMETERS_PER_MINUTE -> LinearVelocityMeasureCentimetersPerMinute(value * CENTIMETERS_PER_SECOND_TO_CENTIMETERS_PER_MINUTE)
            LinearVelocityUnit.MILES_PER_HOUR -> LinearVelocityMeasureMilesPerHour(value * CENTIMETERS_PER_SECOND_TO_MILES_PER_HOUR)
        }
    }

    override fun toAngularVelocity(diameter: Double): AngularVelocityMeasure {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
