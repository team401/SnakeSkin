package org.snakeskin.exception

import org.snakeskin.units.UnitOfMeasure

/**
 * @author Cameron Earle
 * @version 7/15/18
 *
 * Thrown when a unit conversion is not permitted
 */
class IllegalConversionException(fromUnit: UnitOfMeasure, toUnit: UnitOfMeasure): RuntimeException(
        "Cannot convert from unit ${fromUnit.javaClass.simpleName}.$fromUnit to unit ${toUnit.javaClass.simpleName}.$toUnit"
)