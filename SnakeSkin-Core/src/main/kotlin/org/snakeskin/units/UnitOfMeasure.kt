package org.snakeskin.units

import org.snakeskin.units.measure.Measure

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 */
interface UnitOfMeasure {
    fun <M> convert(measure: Measure<*, M>, desiredUnit: UnitOfMeasure): M
    fun <M> createMeasure(): M
}