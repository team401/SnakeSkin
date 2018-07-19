package org.snakeskin.units

import org.snakeskin.units.measure.time.TimeMeasure

/**
 * @author Cameron Earle
 * @version 7/15/18
 */

interface TimeUnit: UnitOfMeasure<TimeMeasure> {
    enum class Standard: TimeUnit, StandardUnitOfMeasure<TimeMeasure> {
        MILLISECONDS,
        SECONDS,
        MINUTES,
        HOURS
    }
}