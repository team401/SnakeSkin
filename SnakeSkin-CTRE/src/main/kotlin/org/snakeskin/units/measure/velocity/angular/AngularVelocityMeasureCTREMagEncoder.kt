package org.snakeskin.units.measure.velocity.angular

import org.snakeskin.units.AngularVelocityUnit
import org.snakeskin.units.AngularVelocityUnitCTREMagEncoder

/**
 * @author Cameron Earle
 * @version 7/19/2018
 *
 */
class AngularVelocityMeasureCTREMagEncoder(override val value: Double): AngularVelocityMeasure {
    companion object {
        const val MAG_ENCODER_TICKS_PER_HUNDRED_MS_TO_REVOLUTIONS_PER_SECOND = 10.0 / 4096.0
        const val MAG_ENCODER_TICKS_PER_HUNDRED_MS_TO_REVOLUTIONS_PER_MINUTE = 600.0 / 4096.0
        const val MAG_ENCODER_TICKS_PER_HUNDRED_MS_TO_RADIANS_PER_SECOND = (20.0 * Math.PI) / 4096.0
        const val MAG_ENCODER_TICKS_PER_HUNDRED_MS_TO_DEGREES_PER_SECOND = 3600.0 / 4096.0
    }

    override val unit: AngularVelocityUnit
        get() = AngularVelocityUnitCTREMagEncoder

    override fun toUnit(unit: AngularVelocityUnit): AngularVelocityMeasure {
        return when (unit) {
            AngularVelocityUnitCTREMagEncoder -> this
            AngularVelocityUnit.Standard.REVOLUTIONS_PER_SECOND -> AngularVelocityMeasureRevolutionsPerSecond(value * MAG_ENCODER_TICKS_PER_HUNDRED_MS_TO_REVOLUTIONS_PER_SECOND)
            AngularVelocityUnit.Standard.REVOLUTIONS_PER_MINUTE -> AngularVelocityMeasureRevolutionsPerMinute(value * MAG_ENCODER_TICKS_PER_HUNDRED_MS_TO_REVOLUTIONS_PER_MINUTE)
            AngularVelocityUnit.Standard.RADIANS_PER_SECOND -> AngularVelocityMeasureRadiansPerSecond(value * MAG_ENCODER_TICKS_PER_HUNDRED_MS_TO_RADIANS_PER_SECOND)
            AngularVelocityUnit.Standard.DEGREES_PER_SECOND -> AngularVelocityMeasureDegreesPerSecond(value * MAG_ENCODER_TICKS_PER_HUNDRED_MS_TO_DEGREES_PER_SECOND)
            else -> unit.convert(this)
        }
    }
}