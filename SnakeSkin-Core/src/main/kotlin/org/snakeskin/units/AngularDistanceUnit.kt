package org.snakeskin.units

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 */
interface AngularDistanceUnit: UnitOfMeasure {
    enum class Standard: AngularDistanceUnit, StandardUnitOfMeasure {
        REVOLUTIONS,
        DEGREES,
        RADIANS
    }

    /**
     * Override this to implement a custom angular velocity creator for your distance unit
     */
    fun createAngularVelocityUnit(timeUnit: TimeUnit): AngularVelocityUnit {
        return AngularVelocityUnit.Standard.create(this, timeUnit)
    }
}