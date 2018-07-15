package org.snakeskin.units.measure.time

import org.snakeskin.units.TimeUnit

/**
 * @author Cameron Earle
 * @version 7/15/18
 *
 * TODO Class to be inlined in Kotlin 1.3
 */
/*inline*/ class TimeMeasureMinutes(override val value: Double): TimeMeasure {
    companion object {
        const val MINUTES_TO_MILLISECONDS = 60000
        const val MINUTES_TO_SECONDS = 60
        const val MINUTES_TO_HOURS = 1 / 60.0
    }

    override val unit: TimeUnit
        get() = TimeUnit.MINUTES

    override fun toUnit(unit: TimeUnit): TimeMeasure {
        return when (unit) {
            TimeUnit.MINUTES -> this
            TimeUnit.MILLISECONDS -> TimeMeasureMinutes(value * MINUTES_TO_MILLISECONDS)
            TimeUnit.SECONDS -> TimeMeasureSeconds(value * MINUTES_TO_SECONDS)
            TimeUnit.HOURS -> TimeMeasureHours(value * MINUTES_TO_HOURS)
        }
    }
}