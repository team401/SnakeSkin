package org.snakeskin.units.measure.velocity.linear

import org.snakeskin.units.LinearVelocityUnit
import org.snakeskin.units.measure.Measure
import org.snakeskin.units.measure.distance.linear.LinearDistanceMeasure
import org.snakeskin.units.measure.time.TimeMeasure
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasure

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 */
interface LinearVelocityMeasure: Measure<LinearVelocityUnit, LinearVelocityMeasure> {
    fun toAngularVelocity(diameter: Double): AngularVelocityMeasure

    /**
     * Produces a linear distance travelled given a dt.
     * The output unit is the corresponding distance unit to this velocity unit
     *
     * The unit of the input dt does not matter, as it will be converted to this measure's time unit
     */
    fun toLinearDistance(dt: TimeMeasure): LinearDistanceMeasure {
        return LinearDistanceMeasure.create(
                this.value * dt.toUnit(this.unit.timeUnit).value,
                this.unit.distanceUnit
        )
    }

    companion object {
        fun create(value: Double, unit: LinearVelocityUnit): LinearVelocityMeasure {
            return when (unit) {
                LinearVelocityUnit.Standard.INCHES_PER_SECOND -> LinearVelocityMeasureInchesPerSecond(value)
                LinearVelocityUnit.Standard.FEET_PER_SECOND -> LinearVelocityMeasureFeetPerSecond(value)
                LinearVelocityUnit.Standard.METERS_PER_SECOND -> LinearVelocityMeasureMetersPerSecond(value)
                LinearVelocityUnit.Standard.CENTIMETERS_PER_SECOND -> LinearVelocityMeasureCentimetersPerSecond(value)
                LinearVelocityUnit.Standard.INCHES_PER_MINUTE -> LinearVelocityMeasureInchesPerMinute(value)
                LinearVelocityUnit.Standard.FEET_PER_MINUTE -> LinearVelocityMeasureFeetPerMinute(value)
                LinearVelocityUnit.Standard.METERS_PER_MINUTE -> LinearVelocityMeasureMetersPerMinute(value)
                LinearVelocityUnit.Standard.CENTIMETERS_PER_MINUTE -> LinearVelocityMeasureCentimetersPerMinute(value)
                LinearVelocityUnit.Standard.MILES_PER_HOUR -> LinearVelocityMeasureMilesPerHour(value)
                else -> unit.createMeasure()
            }
        }
    }
}