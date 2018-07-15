package org.snakeskin.units.measure.velocity.linear

import org.snakeskin.units.LinearVelocityUnit
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasure

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 * TODO Class to be inlined in Kotlin 1.3
 */

/*inline*/ class LinearVelocityMeasureFeetPerSecond(override val value: Double): LinearVelocityMeasure {
    companion object {
        const val FEET_PER_SECOND_TO_INCHES_PER_SECOND = 12.0
        const val FEET_PER_SECOND_TO_METERS_PER_SECOND = 0.3048
        const val FEET_PER_SECOND_TO_CENTIMETERS_PER_SECOND = 30.48
        const val FEET_PER_SECOND_TO_INCHES_PER_MINUTE = 720.0
        const val FEET_PER_SECOND_TO_FEET_PER_MINUTE = 60.0
        const val FEET_PER_SECOND_TO_METERS_PER_MINUTE = 18.288
        const val FEET_PER_SECOND_TO_CENTIMETERS_PER_MINUTE = 1828.8
        const val FEET_PER_SECOND_TO_MILES_PER_HOUR = 0.681818182
    }

    override val unit: LinearVelocityUnit
        get() = LinearVelocityUnit.FEET_PER_SECOND

    override fun inUnit(unit: LinearVelocityUnit): LinearVelocityMeasure {
        return when (unit) {
            LinearVelocityUnit.FEET_PER_SECOND -> this
            LinearVelocityUnit.INCHES_PER_SECOND -> LinearVelocityMeasureInchesPerSecond(value * FEET_PER_SECOND_TO_INCHES_PER_SECOND)
            LinearVelocityUnit.METERS_PER_SECOND -> LinearVelocityMeasureMetersPerSecond(value * FEET_PER_SECOND_TO_METERS_PER_SECOND)
            LinearVelocityUnit.CENTIMETERS_PER_SECOND -> LinearVelocityMeasureCentimetersPerSecond(value * FEET_PER_SECOND_TO_CENTIMETERS_PER_SECOND)
            LinearVelocityUnit.INCHES_PER_MINUTE -> LinearVelocityMeasureInchesPerMinute(value * FEET_PER_SECOND_TO_INCHES_PER_MINUTE)
            LinearVelocityUnit.FEET_PER_MINUTE -> LinearVelocityMeasureFeetPerMinute(value * FEET_PER_SECOND_TO_FEET_PER_MINUTE)
            LinearVelocityUnit.METERS_PER_MINUTE -> LinearVelocityMeasureMetersPerMinute(value * FEET_PER_SECOND_TO_METERS_PER_MINUTE)
            LinearVelocityUnit.CENTIMETERS_PER_MINUTE -> LinearVelocityMeasureCentimetersPerMinute(value * FEET_PER_SECOND_TO_CENTIMETERS_PER_MINUTE)
            LinearVelocityUnit.MILES_PER_HOUR -> LinearVelocityMeasureMilesPerHour(value * FEET_PER_SECOND_TO_MILES_PER_HOUR)
        }
    }

    override fun toAngularVelocity(diameter: Double): AngularVelocityMeasure {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
