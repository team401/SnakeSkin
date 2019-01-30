package org.snakeskin.units.measure.time

import org.snakeskin.units.TimeUnit

/**
 * @author Cameron Earle
 * @version 7/15/18
 *
 */
inline class TimeMeasureSeconds(override val value: Double): TimeMeasure {
    companion object {
        const val SECONDS_TO_MILLISECONDS = 1000.0
        const val SECONDS_TO_MINUTES = 1 / 60.0
        const val SECONDS_TO_HOURS = 1 / 3600.0
    }

    override val unit: TimeUnit
        get() = TimeUnit.Standard.SECONDS

    override fun toUnit(unit: TimeUnit): TimeMeasure {
        return when (unit) {
            TimeUnit.Standard.SECONDS -> this
            TimeUnit.Standard.MILLISECONDS -> TimeMeasureMilliseconds(value * SECONDS_TO_MILLISECONDS)
            TimeUnit.Standard.MINUTES -> TimeMeasureMinutes(value * SECONDS_TO_MINUTES)
            TimeUnit.Standard.HOURS -> TimeMeasureHours(value * SECONDS_TO_HOURS)
            else -> unit.convert(this)
        }
    }

    override fun toString(): String {
        return "$value sec"
    }
}