package org.snakeskin.units

/**
 * @author Cameron Earle
 * @version 7/15/18
 *
 * Interface to allow custom units of measure to be created
 *
 * @param M the type of the measure that this unit will produce
 */
interface NonStandardUnitOfMeasure<M>: UnitOfMeasure {
    /**
     * Handles a unit conversion given a value, current unit, and desired unit.
     * Implementations should return null if the conversion is not possible
     */
    fun handleConversion(value: Double, currentUnit: UnitOfMeasure, desiredUnit: UnitOfMeasure): M?
}