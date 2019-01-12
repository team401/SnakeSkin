package org.snakeskin.units.measure.velocity.linear

import org.snakeskin.units.AngularVelocityUnit
import org.snakeskin.units.LinearVelocityUnit
import org.snakeskin.units.measure.Measure
import org.snakeskin.units.measure.distance.linear.LinearDistanceMeasure
import org.snakeskin.units.measure.time.TimeMeasure
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasure
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasureRadiansPerSecond

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 */
interface LinearVelocityMeasure: Measure<LinearVelocityUnit, LinearVelocityMeasure> {

    /**
     * Converts this linear velocity to an angular velocity, given a radius
     *
     * Output unit is radians per second
     */
    fun toAngularVelocity(radius: LinearDistanceMeasure): AngularVelocityMeasure {
        return AngularVelocityMeasureRadiansPerSecond(this.value / radius.toUnit(this.unit.distanceUnit).value)
    }

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
                else -> unit.createMeasure(value)
            }
        }
    }

    operator fun plus(other: LinearVelocityMeasure): LinearVelocityMeasure {
        return create((this.value + other.toUnit(this.unit).value), this.unit)
    }

    operator fun minus(other: LinearVelocityMeasure): LinearVelocityMeasure {
        return create((this.value - other.toUnit(this.unit).value), this.unit)
    }

    operator fun div(other: LinearVelocityMeasure): LinearVelocityMeasure {
        return create((this.value / other.toUnit(this.unit).value), this.unit)
    }

    operator fun times(other: LinearVelocityMeasure): LinearVelocityMeasure {
        return create((this.value * other.toUnit(this.unit).value), this.unit)
    }

    operator fun plus(other: Double): LinearVelocityMeasure {
        return create((this.value + other), this.unit)
    }

    operator fun minus(other: Double): LinearVelocityMeasure {
        return create((this.value - other), this.unit)
    }

    operator fun div(other: Double): LinearVelocityMeasure {
        return create((this.value / other), this.unit)
    }

    operator fun times(other: Double): LinearVelocityMeasure {
        return create((this.value * other), this.unit)
    }

    operator fun compareTo(other: LinearVelocityMeasure): Int {
        val otherVal = other.toUnit(this.unit).value
        return when {
            this.value < otherVal -> -1
            this.value > otherVal -> 1
            else -> 0
        }
    }
}