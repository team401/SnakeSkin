package org.snakeskin.units.measure

import org.snakeskin.units.Inches
import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasure
import org.snakeskin.units.measure.distance.linear.LinearDistanceMeasure
import org.snakeskin.units.measure.time.TimeMeasure
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasure
import org.snakeskin.units.measure.velocity.linear.LinearVelocityMeasure

/**
 * @author Cameron Earle
 * @version 1/28/2019
 *
 */
inline class UnitlessMeasure(val value: Double) {
    //Angular distance
    operator fun plus(other: AngularDistanceMeasure): AngularDistanceMeasure {
        return AngularDistanceMeasure.create((this.value + other.value), other.unit)
    }

    operator fun minus(other: AngularDistanceMeasure): AngularDistanceMeasure {
        return AngularDistanceMeasure.create((this.value - other.value), other.unit)
    }

    operator fun div(other: AngularDistanceMeasure): AngularDistanceMeasure {
        return AngularDistanceMeasure.create((this.value / other.value), other.unit)
    }

    operator fun times(other: AngularDistanceMeasure): AngularDistanceMeasure {
        return AngularDistanceMeasure.create((this.value * other.value), other.unit)
    }

    //Linear distance
    operator fun plus(other: LinearDistanceMeasure): LinearDistanceMeasure {
        return LinearDistanceMeasure.create((this.value + other.value), other.unit)
    }

    operator fun minus(other: LinearDistanceMeasure): LinearDistanceMeasure {
        return LinearDistanceMeasure.create((this.value - other.value), other.unit)
    }

    operator fun div(other: LinearDistanceMeasure): LinearDistanceMeasure {
        return LinearDistanceMeasure.create((this.value / other.value), other.unit)
    }

    operator fun times(other: LinearDistanceMeasure): LinearDistanceMeasure {
        return LinearDistanceMeasure.create((this.value * other.value), other.unit)
    }

    //Time
    operator fun plus(other: TimeMeasure): TimeMeasure {
        return TimeMeasure.create((this.value + other.value), other.unit)
    }

    operator fun minus(other: TimeMeasure): TimeMeasure {
        return TimeMeasure.create((this.value - other.value), other.unit)
    }

    operator fun div(other: TimeMeasure): TimeMeasure {
        return TimeMeasure.create((this.value / other.value), other.unit)
    }

    operator fun times(other: TimeMeasure): TimeMeasure {
        return TimeMeasure.create((this.value * other.value), other.unit)
    }

    //Angular velocity
    operator fun plus(other: AngularVelocityMeasure): AngularVelocityMeasure {
        return AngularVelocityMeasure.create((this.value + other.value), other.unit)
    }

    operator fun minus(other: AngularVelocityMeasure): AngularVelocityMeasure {
        return AngularVelocityMeasure.create((this.value - other.value), other.unit)
    }

    operator fun div(other: AngularVelocityMeasure): AngularVelocityMeasure {
        return AngularVelocityMeasure.create((this.value / other.value), other.unit)
    }

    operator fun times(other: AngularVelocityMeasure): AngularVelocityMeasure {
        return AngularVelocityMeasure.create((this.value * other.value), other.unit)
    }

    //Linear velocity
    operator fun plus(other: LinearVelocityMeasure): LinearVelocityMeasure {
        return LinearVelocityMeasure.create((this.value + other.value), other.unit)
    }

    operator fun minus(other: LinearVelocityMeasure): LinearVelocityMeasure {
        return LinearVelocityMeasure.create((this.value - other.value), other.unit)
    }

    operator fun div(other: LinearVelocityMeasure): LinearVelocityMeasure {
        return LinearVelocityMeasure.create((this.value / other.value), other.unit)
    }

    operator fun times(other: LinearVelocityMeasure): LinearVelocityMeasure {
        return LinearVelocityMeasure.create((this.value * other.value), other.unit)
    }
}