package org.snakeskin.units

import org.snakeskin.units.measure.Measure

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 */
interface LinearVelocityUnit: UnitOfMeasure {
    val distanceUnit: LinearDistanceUnit
    val timeUnit: TimeUnit

    enum class Standard(override val distanceUnit: LinearDistanceUnit, override val timeUnit: TimeUnit): LinearVelocityUnit, StandardUnitOfMeasure {
        INCHES_PER_SECOND(LinearDistanceUnit.Standard.INCHES, TimeUnit.Standard.SECONDS),
        FEET_PER_SECOND(LinearDistanceUnit.Standard.FEET, TimeUnit.Standard.SECONDS),
        METERS_PER_SECOND(LinearDistanceUnit.Standard.METERS, TimeUnit.Standard.SECONDS),
        CENTIMETERS_PER_SECOND(LinearDistanceUnit.Standard.CENTIMETERS, TimeUnit.Standard.SECONDS),
        INCHES_PER_MINUTE(LinearDistanceUnit.Standard.INCHES, TimeUnit.Standard.MINUTES),
        FEET_PER_MINUTE(LinearDistanceUnit.Standard.FEET, TimeUnit.Standard.MINUTES),
        METERS_PER_MINUTE(LinearDistanceUnit.Standard.METERS, TimeUnit.Standard.MINUTES),
        CENTIMETERS_PER_MINUTE(LinearDistanceUnit.Standard.CENTIMETERS, TimeUnit.Standard.MINUTES),
        MILES_PER_HOUR(LinearDistanceUnit.Standard.MILES, TimeUnit.Standard.HOURS);

        companion object {
            fun create(distanceUnit: LinearDistanceUnit, timeUnit: TimeUnit): LinearVelocityUnit {
                return values().firstOrNull {
                    it.distanceUnit == distanceUnit && it.timeUnit == timeUnit
                }?: throw NoSuchElementException("Could not create LinearVelocityUnit from LinearDistanceUnit '$distanceUnit' and TimeUnit '$timeUnit'")
            }
        }
    }
}