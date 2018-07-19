package org.snakeskin.units

import org.snakeskin.exception.IllegalConversionException
import org.snakeskin.units.measure.time.TimeMeasure
import org.snakeskin.units.measure.time.TimeMeasure100Ms

/**
 * @author Cameron Earle
 * @version 7/19/2018
 *
 */
object TimeUnit100Ms: TimeUnit {
    const val MILLISECONDS_TO_HUNDRED_MS = 1.0 / 100.0
    const val SECONDS_TO_HUNDRED_MS = 10.0
    const val MINUTES_TO_HUNDRED_MS = 600.0
    const val HOURS_TO_HUNDRED_MS = 36000.0

    override fun convert(measure: TimeMeasure): TimeMeasure {
        return when (measure.unit) {
            TimeUnit.Standard.MILLISECONDS -> TimeMeasure100Ms(measure.value * MILLISECONDS_TO_HUNDRED_MS)
            TimeUnit.Standard.SECONDS -> TimeMeasure100Ms(measure.value * SECONDS_TO_HUNDRED_MS)
            TimeUnit.Standard.MINUTES -> TimeMeasure100Ms(measure.value * MINUTES_TO_HUNDRED_MS)
            TimeUnit.Standard.HOURS -> TimeMeasure100Ms(measure.value * HOURS_TO_HUNDRED_MS)
            else -> throw IllegalConversionException(measure.unit, this)
        }
    }

    override fun createMeasure(value: Double): TimeMeasure {
        return TimeMeasure100Ms(value)
    }
}