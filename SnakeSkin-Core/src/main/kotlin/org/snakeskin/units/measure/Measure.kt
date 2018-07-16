package org.snakeskin.units.measure

import org.snakeskin.units.UnitOfMeasure

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 */

interface Measure<U: UnitOfMeasure, M> {
    val value: Double
    val unit: U

    /**
     * Converts this measure to the desired standard unit
     */
    infix fun toUnit(unit: U): M
}