package org.snakeskin.units

import org.snakeskin.exception.IllegalConversionException
import org.snakeskin.units.measure.distance.linear.LinearDistanceMeasureInches
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasure
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasureCTREMagEncoder
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasureRevolutionsPerSecond
import org.snakeskin.units.measure.velocity.linear.LinearVelocityMeasure
import org.snakeskin.units.measure.velocity.linear.LinearVelocityMeasureInchesPerSecond
import kotlin.math.floor

/**
 * @author Cameron Earle
 * @version 7/19/2018
 *
 */
object AngularVelocityUnitCTREMagEncoder: AngularVelocityUnit {
    const val REVOLUTIONS_PER_SECOND_TO_TICKS_PER_HUNDRED_MS = 4096.0 / 10.0
    const val REVOLUTIONS_PER_MINUTE_TO_TICKS_PER_HUNDRED_MS = 4096.0 / 600.0
    const val RADIANS_PER_SECOND_TO_TICKS_PER_HUNDRED_MS = 4096.0 / (20.0 * Math.PI)
    const val DEGREES_PER_SECOND_TO_TICKS_PER_HUNDRED_MS = 4096.0 / 3600.0

    override val distanceUnit: AngularDistanceUnit
        get() = AngularDistanceUnitCTREMagEncoder

    override val timeUnit: TimeUnit
        get() = TimeUnit100Ms

    override fun createMeasure(value: Double): AngularVelocityMeasure {
        return AngularVelocityMeasureCTREMagEncoder(value)
    }

    override fun convert(measure: AngularVelocityMeasure): AngularVelocityMeasure {
        return when (measure.unit) {
            AngularVelocityUnit.Standard.REVOLUTIONS_PER_SECOND -> AngularVelocityMeasureCTREMagEncoder(measure.value * REVOLUTIONS_PER_SECOND_TO_TICKS_PER_HUNDRED_MS)
            AngularVelocityUnit.Standard.REVOLUTIONS_PER_MINUTE -> AngularVelocityMeasureCTREMagEncoder(measure.value * REVOLUTIONS_PER_MINUTE_TO_TICKS_PER_HUNDRED_MS)
            AngularVelocityUnit.Standard.RADIANS_PER_SECOND -> AngularVelocityMeasureCTREMagEncoder(measure.value * RADIANS_PER_SECOND_TO_TICKS_PER_HUNDRED_MS)
            AngularVelocityUnit.Standard.DEGREES_PER_SECOND -> AngularVelocityMeasureCTREMagEncoder(measure.value * DEGREES_PER_SECOND_TO_TICKS_PER_HUNDRED_MS)
            else -> throw IllegalConversionException(measure.unit, this)
        }
    }
}