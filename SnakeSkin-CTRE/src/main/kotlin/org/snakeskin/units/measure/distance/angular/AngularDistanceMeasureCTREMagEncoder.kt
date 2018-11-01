package org.snakeskin.units.measure.distance.angular

import org.snakeskin.units.AngularDistanceUnit
import org.snakeskin.units.AngularDistanceUnitCTREMagEncoder

/**
 * @author Cameron Earle
 * @version 7/19/2018
 *
 */
class AngularDistanceMeasureCTREMagEncoder(override val value: Double): AngularDistanceMeasure {
    companion object {
        const val MAG_ENCODER_TICKS_TO_REVOLUTIONS = 1.0 / 4096.0
        const val MAG_ENCODER_TICKS_TO_RADIANS = (2 * Math.PI) / 4096.0
        const val MAG_ENCODER_TICKS_TO_DEGREES = 360.0 / 4096.0
    }

    override val unit: AngularDistanceUnit
        get() = AngularDistanceUnitCTREMagEncoder

    override fun toUnit(unit: AngularDistanceUnit): AngularDistanceMeasure {
        return when (unit) {
            AngularDistanceUnitCTREMagEncoder -> this
            AngularDistanceUnit.Standard.REVOLUTIONS -> AngularDistanceMeasureRevolutions(value * MAG_ENCODER_TICKS_TO_REVOLUTIONS)
            AngularDistanceUnit.Standard.RADIANS -> AngularDistanceMeasureRadians(value * MAG_ENCODER_TICKS_TO_RADIANS)
            AngularDistanceUnit.Standard.DEGREES -> AngularDistanceMeasureDegrees(value * MAG_ENCODER_TICKS_TO_DEGREES)
            else -> unit.convert(this)
        }
    }
}