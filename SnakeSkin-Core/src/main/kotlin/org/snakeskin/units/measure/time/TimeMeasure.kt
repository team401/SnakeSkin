package org.snakeskin.units.measure.time

import org.snakeskin.units.TimeUnit
import org.snakeskin.units.measure.Measure

/**
 * @author Cameron Earle
 * @version 7/15/18
 */
interface TimeMeasure: Measure<TimeUnit, TimeMeasure> {

    companion object {
        fun create(value: Double, unit: TimeUnit): TimeMeasure {
            return when (unit) {
                TimeUnit.Standard.MILLISECONDS -> TimeMeasureMilliseconds(value)
                TimeUnit.Standard.SECONDS -> TimeMeasureSeconds(value)
                TimeUnit.Standard.MINUTES -> TimeMeasureMinutes(value)
                TimeUnit.Standard.HOURS -> TimeMeasureHours(value)
                else -> unit.createMeasure(value)
            }
        }
    }


    operator fun plus(other: TimeMeasure): TimeMeasure {
        return create((this.value + other.toUnit(this.unit).value), this.unit)
    }

    operator fun minus(other: TimeMeasure): TimeMeasure {
        return create((this.value - other.toUnit(this.unit).value), this.unit)
    }

    operator fun div(other: TimeMeasure): TimeMeasure {
        return create((this.value / other.toUnit(this.unit).value), this.unit)
    }

    operator fun times(other: TimeMeasure): TimeMeasure {
        return create((this.value * other.toUnit(this.unit).value), this.unit)
    }

    operator fun plus(other: Double): TimeMeasure {
        return create((this.value + other), this.unit)
    }

    operator fun minus(other: Double): TimeMeasure {
        return create((this.value - other), this.unit)
    }

    operator fun div(other: Double): TimeMeasure {
        return create((this.value / other), this.unit)
    }

    operator fun times(other: Double): TimeMeasure {
        return create((this.value * other), this.unit)
    }

    operator fun compareTo(other: TimeMeasure): Int {
        val otherVal = other.toUnit(this.unit).value
        return when {
            this.value < otherVal -> -1
            this.value > otherVal -> 1
            else -> 0
        }
    }
}