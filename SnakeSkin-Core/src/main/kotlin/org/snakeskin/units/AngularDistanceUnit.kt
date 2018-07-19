package org.snakeskin.units

import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasure

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 */
interface AngularDistanceUnit: UnitOfMeasure<AngularDistanceMeasure> {
    enum class Standard: AngularDistanceUnit, StandardUnitOfMeasure<AngularDistanceMeasure> {
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