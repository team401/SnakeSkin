package org.snakeskin.units

/**
 * @author Cameron Earle
 * @version 7/15/18
 */

interface TimeUnit: UnitOfMeasure {
    enum class Standard: TimeUnit, StandardUnitOfMeasure {
        MILLISECONDS,
        SECONDS,
        MINUTES,
        HOURS
    }
}