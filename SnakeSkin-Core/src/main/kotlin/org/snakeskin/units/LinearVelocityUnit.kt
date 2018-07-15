package org.snakeskin.units

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 */
enum class LinearVelocityUnit(val distanceUnit: LinearDistanceUnit, val timeUnit: TimeUnit): UnitOfMeasure {
    INCHES_PER_SECOND(LinearDistanceUnit.INCHES, TimeUnit.SECONDS),
    FEET_PER_SECOND(LinearDistanceUnit.FEET, TimeUnit.SECONDS),
    METERS_PER_SECOND(LinearDistanceUnit.METERS, TimeUnit.SECONDS),
    CENTIMETERS_PER_SECOND(LinearDistanceUnit.CENTIMETERS, TimeUnit.SECONDS),
    INCHES_PER_MINUTE(LinearDistanceUnit.INCHES, TimeUnit.MINUTES),
    FEET_PER_MINUTE(LinearDistanceUnit.FEET, TimeUnit.MINUTES),
    METERS_PER_MINUTE(LinearDistanceUnit.METERS, TimeUnit.MINUTES),
    CENTIMETERS_PER_MINUTE(LinearDistanceUnit.CENTIMETERS, TimeUnit.MINUTES),
    MILES_PER_HOUR(LinearDistanceUnit.MILES, TimeUnit.HOURS);

    companion object {
        fun create(distanceUnit: LinearDistanceUnit, timeUnit: TimeUnit): LinearVelocityUnit {
            return values().firstOrNull {
                it.distanceUnit == distanceUnit && it.timeUnit == timeUnit
            }?: throw NoSuchElementException("Could not create LinearVelocityUnit from LinearDistanceUnit '$distanceUnit' and TimeUnit '$timeUnit'")
        }
    }
}