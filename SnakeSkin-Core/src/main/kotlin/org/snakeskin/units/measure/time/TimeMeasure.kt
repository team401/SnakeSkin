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
                else -> unit.createMeasure()
            }
        }
    }
}