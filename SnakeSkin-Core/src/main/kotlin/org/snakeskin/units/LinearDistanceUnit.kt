package org.snakeskin.units

import org.snakeskin.units.measure.distance.linear.LinearDistanceMeasure
import org.snakeskin.units.measure.time.TimeMeasure

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 */

interface LinearDistanceUnit: UnitOfMeasure<LinearDistanceMeasure> {
    enum class Standard: LinearDistanceUnit, StandardUnitOfMeasure<LinearDistanceMeasure> {
        INCHES,
        FEET,
        CENTIMETERS,
        METERS,
        MILES
    }

    /**
     * Override this to implement a custom linear velocity creator for your distance unit
     */
    fun createLinearVelocityUnit(timeUnit: TimeUnit): LinearVelocityUnit {
        return LinearVelocityUnit.Standard.create(this, timeUnit)
    }
}