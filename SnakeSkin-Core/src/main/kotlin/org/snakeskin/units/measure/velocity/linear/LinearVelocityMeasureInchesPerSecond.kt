package org.snakeskin.units.measure.velocity.linear

import org.snakeskin.units.LinearVelocityUnit
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasure

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 * TODO Class to be inlined in Kotlin 1.3
 */
/*inline*/ class LinearVelocityMeasureInchesPerSecond(override val value: Double): LinearVelocityMeasure {
    companion object {
        const val INCHES_PER_SECOND_TO_FEET_PER_SECOND = 0.083333333
        const val INCHES_PER_SECOND_TO_METERS_PER_SECOND = 0.0254
        const val INCHES_PER_SECOND_TO_CENTIMETERS_PER_SECOND = 2.54
        const val INCHES_PER_SECOND_TO_INCHES_PER_MINUTE = 60.0
        const val INCHES_PER_SECOND_TO_FEET_PER_MINUTE = 5.0
        const val INCHES_PER_SECOND_TO_METERS_PER_MINUTE = 1.524
        const val INCHES_PER_SECOND_TO_CENTIMETERS_PER_MINUTE = 152.4
        const val INCHES_PER_SECOND_TO_MILES_PER_HOUR = 0.056818182
    }

    override val unit: LinearVelocityUnit
        get() = LinearVelocityUnit.INCHES_PER_SECOND

    override fun toUnit(unit: LinearVelocityUnit): LinearVelocityMeasure {
        return when (unit) {
            LinearVelocityUnit.INCHES_PER_SECOND -> this
            LinearVelocityUnit.FEET_PER_SECOND -> LinearVelocityMeasureFeetPerSecond(value * INCHES_PER_SECOND_TO_FEET_PER_SECOND)
            LinearVelocityUnit.METERS_PER_SECOND -> LinearVelocityMeasureMetersPerSecond(value * INCHES_PER_SECOND_TO_METERS_PER_SECOND)
            LinearVelocityUnit.CENTIMETERS_PER_SECOND -> LinearVelocityMeasureCentimetersPerSecond(value * INCHES_PER_SECOND_TO_CENTIMETERS_PER_SECOND)
            LinearVelocityUnit.INCHES_PER_MINUTE -> LinearVelocityMeasureInchesPerMinute(value * INCHES_PER_SECOND_TO_INCHES_PER_MINUTE)
            LinearVelocityUnit.FEET_PER_MINUTE -> LinearVelocityMeasureFeetPerMinute(value * INCHES_PER_SECOND_TO_FEET_PER_MINUTE)
            LinearVelocityUnit.METERS_PER_MINUTE -> LinearVelocityMeasureMetersPerMinute(value * INCHES_PER_SECOND_TO_METERS_PER_MINUTE)
            LinearVelocityUnit.CENTIMETERS_PER_MINUTE -> LinearVelocityMeasureCentimetersPerMinute(value * INCHES_PER_SECOND_TO_CENTIMETERS_PER_MINUTE)
            LinearVelocityUnit.MILES_PER_HOUR -> LinearVelocityMeasureMilesPerHour(value * INCHES_PER_SECOND_TO_MILES_PER_HOUR)
        }
    }

    override fun toAngularVelocity(diameter: Double): AngularVelocityMeasure {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
