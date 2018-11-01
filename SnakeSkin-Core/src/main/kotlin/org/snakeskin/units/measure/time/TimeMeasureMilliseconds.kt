package org.snakeskin.units.measure.time

import org.snakeskin.units.TimeUnit

/**
 * @author Cameron Earle
 * @version 7/15/18
 *
 */
inline class TimeMeasureMilliseconds(override val value: Double): TimeMeasure {
    companion object {
        const val MILLISECONDS_TO_SECONDS = 0.001
        const val MILLISECONDS_TO_MINUTES = 1.66667e-5
        const val MILLISECONDS_TO_HOURS = 2.77778e-7
    }

    override val unit: TimeUnit
        get() = TimeUnit.Standard.MILLISECONDS

    override fun toUnit(unit: TimeUnit): TimeMeasure {
        return when (unit) {
            TimeUnit.Standard.MILLISECONDS -> this
            TimeUnit.Standard.SECONDS -> TimeMeasureSeconds(value * MILLISECONDS_TO_SECONDS)
            TimeUnit.Standard.MINUTES -> TimeMeasureMinutes(value * MILLISECONDS_TO_MINUTES)
            TimeUnit.Standard.HOURS -> TimeMeasureHours(value * MILLISECONDS_TO_HOURS)
            else -> unit.convert(this)
        }
    }
}