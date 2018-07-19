package org.snakeskin.units

import org.snakeskin.exception.IllegalConversionException
import org.snakeskin.units.measure.Measure
import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasure
import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasureCTREMagEncoder

/**
 * @author Cameron Earle
 * @version 7/19/2018
 *
 */

object AngularDistanceUnitCTREMagEncoder: AngularDistanceUnit {
    const val REVOLUTIONS_TO_MAG_ENCODER_TICKS = 4096.0
    const val RADIANS_TO_MAG_ENCODER_TICKS = 4096.0 / (2 * Math.PI)
    const val DEGREES_TO_MAG_ENCODER_TICKS = 4096.0 / 360.0

    override fun createMeasure(value: Double): AngularDistanceMeasure {
        return AngularDistanceMeasureCTREMagEncoder(value)
    }

    override fun convert(measure: AngularDistanceMeasure): AngularDistanceMeasure {
        return when (measure.unit) {
            AngularDistanceUnit.Standard.REVOLUTIONS -> AngularDistanceMeasureCTREMagEncoder(measure.value * REVOLUTIONS_TO_MAG_ENCODER_TICKS)
            AngularDistanceUnit.Standard.RADIANS -> AngularDistanceMeasureCTREMagEncoder(measure.value * RADIANS_TO_MAG_ENCODER_TICKS)
            AngularDistanceUnit.Standard.DEGREES -> AngularDistanceMeasureCTREMagEncoder(measure.value * DEGREES_TO_MAG_ENCODER_TICKS)
            else -> throw IllegalConversionException(measure.unit, this)
        }
    }
}