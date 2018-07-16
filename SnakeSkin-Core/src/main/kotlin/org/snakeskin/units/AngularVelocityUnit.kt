package org.snakeskin.units

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 */
interface AngularVelocityUnit: UnitOfMeasure {
    val distanceUnit: AngularDistanceUnit
    val timeUnit: TimeUnit

    enum class Standard(override val distanceUnit: AngularDistanceUnit, override val timeUnit: TimeUnit): AngularVelocityUnit, StandardUnitOfMeasure {
        REVOLUTIONS_PER_SECOND(AngularDistanceUnit.Standard.REVOLUTIONS, TimeUnit.Standard.SECONDS),
        REVOLUTIONS_PER_MINUTE(AngularDistanceUnit.Standard.REVOLUTIONS, TimeUnit.Standard.MINUTES),
        RADIANS_PER_SECOND(AngularDistanceUnit.Standard.RADIANS, TimeUnit.Standard.SECONDS),
        DEGREES_PER_SECOND(AngularDistanceUnit.Standard.DEGREES, TimeUnit.Standard.SECONDS);

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
}