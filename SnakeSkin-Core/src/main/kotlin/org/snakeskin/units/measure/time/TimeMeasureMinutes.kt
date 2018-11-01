package org.snakeskin.units.measure.time

import org.snakeskin.units.TimeUnit

/**
 * @author Cameron Earle
 * @version 7/15/18
 *
 */
class TimeMeasureMinutes(override val value: Double): TimeMeasure {
    companion object {
        const val MINUTES_TO_MILLISECONDS = 60000
        const val MINUTES_TO_SECONDS = 60
        const val MINUTES_TO_HOURS = 1 / 60.0
    }

    override val unit: TimeUnit
        get() = TimeUnit.Standard.MINUTES

    override fun toUnit(unit: TimeUnit): TimeMeasure {
        return when (unit) {
            TimeUnit.Standard.MINUTES -> this
            TimeUnit.Standard.MILLISECONDS -> TimeMeasureMinutes(value * MINUTES_TO_MILLISECONDS)
            TimeUnit.Standard.SECONDS -> TimeMeasureSeconds(value * MINUTES_TO_SECONDS)
            TimeUnit.Standard.HOURS -> TimeMeasureHours(value * MINUTES_TO_HOURS)
            else -> unit.convert(this)
        }
    }
}