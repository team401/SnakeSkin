package org.snakeskin.units

import org.snakeskin.units.measure.Measure

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 */
interface UnitOfMeasure<M> {
    fun convert(measure: M): M
    fun createMeasure(value: Double): M
}