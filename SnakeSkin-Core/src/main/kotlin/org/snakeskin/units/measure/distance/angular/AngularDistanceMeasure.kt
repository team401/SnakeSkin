package org.snakeskin.units.measure.distance.angular

import org.snakeskin.units.AngularDistanceUnit
import org.snakeskin.units.measure.Measure
import org.snakeskin.units.measure.distance.linear.LinearDistanceMeasure
import org.snakeskin.units.measure.time.TimeMeasure
import org.snakeskin.units.AngularVelocityUnit
import org.snakeskin.units.measure.UnitlessMeasure
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasure

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 */
interface AngularDistanceMeasure: Measure<AngularDistanceUnit, AngularDistanceMeasure> {

    /**
     * Produces a linear distance from this angle given a radius
     *
     * Calculation is done in radians, output unit is the unit of the radius
     */
    fun toLinearDistance(radius: LinearDistanceMeasure): LinearDistanceMeasure {
        return LinearDistanceMeasure.create(
                radius.value * this.toUnit(AngularDistanceUnit.Standard.RADIANS).value,
                radius.unit
        )
    }

    /**
     * Produces an angular velocity from a second distance measurement
     * The output unit is (this distance unit / dt time unit)
     *
     * Note that not all possible distance/time combinations exist,
     * so be sure to choose your dt unit carefully (for example,
     * minutes can only be used for revolutions, hours and milliseconds cannot be used)
     *
     * @see AngularVelocityUnit for possible combinations
     */
    fun toAngularVelocity(other: AngularDistanceMeasure, dt: TimeMeasure) {
        AngularVelocityMeasure.create(
                (other.toUnit(this.unit).value - this.value) / dt.value,
                this.unit.createAngularVelocityUnit(dt.unit)
        )
    }

    companion object {
        fun create(value: Double, unit: AngularDistanceUnit): AngularDistanceMeasure {
            return when (unit) {
                AngularDistanceUnit.Standard.REVOLUTIONS -> AngularDistanceMeasureRevolutions(value)
                AngularDistanceUnit.Standard.RADIANS -> AngularDistanceMeasureRadians(value)
                AngularDistanceUnit.Standard.DEGREES -> AngularDistanceMeasureDegrees(value)
                else -> unit.createMeasure(value)
            }
        }
    }


    operator fun plus(other: AngularDistanceMeasure): AngularDistanceMeasure {
        return create((this.value + other.toUnit(this.unit).value), this.unit)
    }

    operator fun minus(other: AngularDistanceMeasure): AngularDistanceMeasure {
        return create((this.value - other.toUnit(this.unit).value), this.unit)
    }

    operator fun div(other: AngularDistanceMeasure): AngularDistanceMeasure {
        return create((this.value / other.toUnit(this.unit).value), this.unit)
    }

    operator fun times(other: AngularDistanceMeasure): AngularDistanceMeasure {
        return create((this.value * other.toUnit(this.unit).value), this.unit)
    }

    operator fun plus(other: UnitlessMeasure): AngularDistanceMeasure {
        return create((this.value + other.value), this.unit)
    }

    operator fun minus(other: UnitlessMeasure): AngularDistanceMeasure {
        return create((this.value - other.value), this.unit)
    }

    operator fun div(other: UnitlessMeasure): AngularDistanceMeasure {
        return create((this.value / other.value), this.unit)
    }

    operator fun times(other: UnitlessMeasure): AngularDistanceMeasure {
        return create((this.value * other.value), this.unit)
    }

    operator fun compareTo(other: AngularDistanceMeasure): Int {
        val otherVal = other.toUnit(this.unit).value
        return when {
            this.value < otherVal -> -1
            this.value > otherVal -> 1
            else -> 0
        }
    }
}