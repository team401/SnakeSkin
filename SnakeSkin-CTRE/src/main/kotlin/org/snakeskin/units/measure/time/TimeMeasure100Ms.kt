package org.snakeskin.units.measure.time

import org.snakeskin.units.TimeUnit
import org.snakeskin.units.TimeUnit100Ms

/**
 * @author Cameron Earle
 * @version 7/19/2018
 *
 */
class TimeMeasure100Ms(override val value: Double): TimeMeasure {
    companion object {
        const val HUNDRED_MS_TO_MILLISECONDS = 100.0
        const val HUNDRED_MS_TO_SECONDS = 0.1
        const val HUNDRED_MS_TO_MINUTES = 1.0 / 600.0
        const val HUNDRED_MS_TO_HOURS = 1.0 / 36000.0
    }

    override val unit: TimeUnit
        get() = TimeUnit100Ms

    override fun toUnit(unit: TimeUnit): TimeMeasure {
        return when (unit) {
            TimeUnit100Ms -> this
            TimeUnit.Standard.MILLISECONDS -> TimeMeasureMilliseconds(value * HUNDRED_MS_TO_MILLISECONDS)
            TimeUnit.Standard.SECONDS -> TimeMeasureSeconds(value * HUNDRED_MS_TO_SECONDS)
            TimeUnit.Standard.MINUTES -> TimeMeasureMinutes(value * HUNDRED_MS_TO_MINUTES)
            TimeUnit.Standard.HOURS -> TimeMeasureHours(value * HUNDRED_MS_TO_HOURS)
            else -> unit.convert(this)
        }
    }


    override fun equals(other: Any?): Boolean {
        if (other is TimeMeasure) {
            val converted = other.toUnit(unit).value
            return converted == value
        }
        return false
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun toString(): String {
        return "$value 100ms"
    }
}