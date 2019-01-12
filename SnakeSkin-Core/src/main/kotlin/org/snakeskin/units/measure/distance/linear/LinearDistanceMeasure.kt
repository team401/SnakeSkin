package org.snakeskin.units.measure.distance.linear

import org.snakeskin.units.LinearDistanceUnit
import org.snakeskin.units.LinearVelocityUnit
import org.snakeskin.units.measure.Measure
import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasure
import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasureRadians
import org.snakeskin.units.measure.time.TimeMeasure
import org.snakeskin.units.measure.velocity.linear.LinearVelocityMeasure

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 */
interface LinearDistanceMeasure: Measure<LinearDistanceUnit, LinearDistanceMeasure> {

    /**
     * Produces an angular distance from this linear distance given a radius
     *
     * Output unit is radians
     */
    fun toAngularDistance(radius: LinearDistanceMeasure): AngularDistanceMeasure {
        return AngularDistanceMeasureRadians(this.value / radius.toUnit(this.unit).value)
    }

    /**
     * Produces a linear velocity from a second distance measurement
     * The output unit is (this distance unit / dt time unit)
     *
     * Note that not all possible distance/time combinations exist,
     * so be sure to choose your dt unit carefully (for example,
     * hours can only be used if this distance measure is in miles)
     *
     * @see LinearVelocityUnit for possible combinations
     */
    fun toLinearVelocity(other: LinearDistanceMeasure, dt: TimeMeasure): LinearVelocityMeasure {
        return LinearVelocityMeasure.create(
                (other.toUnit(this.unit).value - this.value) / dt.value,
                this.unit.createLinearVelocityUnit(dt.unit)
        )
    }

    companion object {
        fun create(value: Double, unit: LinearDistanceUnit): LinearDistanceMeasure {
            return when (unit) {
                LinearDistanceUnit.Standard.INCHES -> LinearDistanceMeasureInches(value)
                LinearDistanceUnit.Standard.FEET -> LinearDistanceMeasureFeet(value)
                LinearDistanceUnit.Standard.CENTIMETERS -> LinearDistanceMeasureCentimeters(value)
                LinearDistanceUnit.Standard.METERS -> LinearDistanceMeasureMeters(value)
                LinearDistanceUnit.Standard.MILES -> LinearDistanceMeasureMiles(value)
                else -> unit.createMeasure(value)
            }
        }
    }


    operator fun plus(other: LinearDistanceMeasure): LinearDistanceMeasure {
        return create((this.value + other.toUnit(this.unit).value), this.unit)
    }

    operator fun minus(other: LinearDistanceMeasure): LinearDistanceMeasure {
        return create((this.value - other.toUnit(this.unit).value), this.unit)
    }

    operator fun div(other: LinearDistanceMeasure): LinearDistanceMeasure {
        return create((this.value / other.toUnit(this.unit).value), this.unit)
    }

    operator fun times(other: LinearDistanceMeasure): LinearDistanceMeasure {
        return create((this.value * other.toUnit(this.unit).value), this.unit)
    }

    operator fun plus(other: Double): LinearDistanceMeasure {
        return create((this.value + other), this.unit)
    }

    operator fun minus(other: Double): LinearDistanceMeasure {
        return create((this.value - other), this.unit)
    }

    operator fun div(other: Double): LinearDistanceMeasure {
        return create((this.value / other), this.unit)
    }

    operator fun times(other: Double): LinearDistanceMeasure {
        return create((this.value * other), this.unit)
    }

    operator fun compareTo(other: LinearDistanceMeasure): Int {
        val otherVal = other.toUnit(this.unit).value
        return when {
            this.value < otherVal -> -1
            this.value > otherVal -> 1
            else -> 0
        }
    }
}