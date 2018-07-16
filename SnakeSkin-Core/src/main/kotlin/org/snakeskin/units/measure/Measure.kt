package org.snakeskin.units.measure

import org.snakeskin.exception.IllegalConversionException
import org.snakeskin.units.NonStandardUnitOfMeasure
import org.snakeskin.units.StandardUnitOfMeasure

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 */

interface Measure<U: StandardUnitOfMeasure, M> {
    val value: Double
    val unit: U

    /**
     * Converts this measure to the desired standard unit
     */
    infix fun toUnit(unit: U): M

    /**
     * Converts this measure to the desired unit
     *
     * Conversions are handled by the unit itself, so keep in mind
     * that not all conversions may be supported.  Make sure to check
     * the class of your unit first to see if it supports the desired conversion
     */
    infix fun toUnit(unit: NonStandardUnitOfMeasure<M>): M {
        return unit.handleConversion(value, this.unit, unit)?: throw IllegalConversionException(this.unit, unit)
    }
}