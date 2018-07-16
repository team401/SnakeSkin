package org.snakeskin.units

import org.snakeskin.units.measure.Measure

/**
 * @author Cameron Earle
 * @version 7/15/18
 *
 * Standard conversions are handled in their respective container classes,
 * so there is no need to implement this method on the standard enums.
 * If the container class is implemented correctly, the method should never be called
 */
interface StandardUnitOfMeasure: UnitOfMeasure {
    override fun <M> convert(measure: Measure<*, M>): M {
        throw NotImplementedError("Attempted to convert a standard unit outside of its container class!")
    }

    override fun <M> createMeasure(): M {
        throw NotImplementedError("Attempted to create standard unit measure outside of its container class!")
    }
}