package org.snakeskin.units.measure.time

import org.snakeskin.units.TimeUnit

/**
 * @author Cameron Earle
 * @version 7/15/18
 *
 */
class TimeMeasureHours(override val value: Double): TimeMeasure {
    companion object {
        const val HOURS_TO_MILLISECONDS = 3.6e+6
        const val HOURS_TO_SECONDS = 3600.0
        const val HOURS_TO_MINUTES = 60.0
    }

    override val unit: TimeUnit
        get() = TimeUnit.Standard.HOURS

    override fun toUnit(unit: TimeUnit): TimeMeasure {
        return when (unit) {
            TimeUnit.Standard.HOURS -> this
            TimeUnit.Standard.MILLISECONDS -> TimeMeasureMilliseconds(value * HOURS_TO_MILLISECONDS)
            TimeUnit.Standard.SECONDS -> TimeMeasureSeconds(value * HOURS_TO_SECONDS)
            TimeUnit.Standard.MINUTES -> TimeMeasureMinutes(value * HOURS_TO_MINUTES)
            else -> unit.convert(this)
        }
    }
}