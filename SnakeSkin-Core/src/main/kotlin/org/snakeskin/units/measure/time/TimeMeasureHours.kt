package org.snakeskin.units.measure.time

import org.snakeskin.units.TimeUnit

/**
 * @author Cameron Earle
 * @version 7/15/18
 *
 * TODO Class to be inlined in Kotlin 1.3
 */
/*inline*/ class TimeMeasureHours(override val value: Double): TimeMeasure {
    companion object {
        const val HOURS_TO_MILLISECONDS = 3.6e+6
        const val HOURS_TO_SECONDS = 3600.0
        const val HOURS_TO_MINUTES = 60.0
    }

    override val unit: TimeUnit
        get() = TimeUnit.HOURS

    override fun toUnit(unit: TimeUnit): TimeMeasure {
        return when (unit) {
            TimeUnit.HOURS -> this
            TimeUnit.MILLISECONDS -> TimeMeasureMilliseconds(value * HOURS_TO_MILLISECONDS)
            TimeUnit.SECONDS -> TimeMeasureSeconds(value * HOURS_TO_SECONDS)
            TimeUnit.MINUTES -> TimeMeasureMinutes(value * HOURS_TO_MINUTES)
        }
    }
}