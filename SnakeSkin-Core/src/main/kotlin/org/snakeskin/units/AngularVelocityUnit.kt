package org.snakeskin.units

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 */
enum class AngularVelocityUnit(val distanceUnit: AngularDistanceUnit, val timeUnit: TimeUnit): StandardUnitOfMeasure {
    REVOLUTIONS_PER_SECOND(AngularDistanceUnit.REVOLUTIONS, TimeUnit.SECONDS),
    REVOLUTIONS_PER_MINUTE(AngularDistanceUnit.REVOLUTIONS, TimeUnit.MINUTES),
    RADIANS_PER_SECOND(AngularDistanceUnit.RADIANS, TimeUnit.SECONDS),
    DEGREES_PER_SECOND(AngularDistanceUnit.DEGREES, TimeUnit.SECONDS);

    companion object {
        /**
         * Creates an AngularVelocityUnit from the given AngularDistanceUnit and TimeUnit
         */
        fun create(distanceUnit: AngularDistanceUnit, timeUnit: TimeUnit): AngularVelocityUnit {
            return values().firstOrNull {
                it.distanceUnit == distanceUnit && it.timeUnit == timeUnit
            }?: throw NoSuchElementException("Could not create AngularVelocityUnit from AngularDistanceUnit '$distanceUnit' and TimeUnit '$timeUnit'")
        }
    }
}