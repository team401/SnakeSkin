package org.snakeskin.units.measure.time

import org.snakeskin.units.TimeUnit

/**
 * @author Cameron Earle
 * @version 7/15/18
 *
 * TODO Class to be inlined in Kotlin 1.3
 */
/*inline*/ class TimeMeasureSeconds(override val value: Double): TimeMeasure {
    companion object {
        const val SECONDS_TO_MILLISECONDS = 1000.0
        const val SECONDS_TO_MINUTES = 1 / 60.0
        const val SECONDS_TO_HOURS = 1 / 3600.0
    }

    override val unit: TimeUnit
        get() = TimeUnit.SECONDS

    override fun toUnit(unit: TimeUnit): TimeMeasure {
        return when (unit) {
            TimeUnit.SECONDS -> this
            TimeUnit.MILLISECONDS -> TimeMeasureMilliseconds(value * SECONDS_TO_MILLISECONDS)
            TimeUnit.MINUTES -> TimeMeasureMinutes(value * SECONDS_TO_MINUTES)
            TimeUnit.HOURS -> TimeMeasureHours(value * SECONDS_TO_HOURS)
        }
    }
}