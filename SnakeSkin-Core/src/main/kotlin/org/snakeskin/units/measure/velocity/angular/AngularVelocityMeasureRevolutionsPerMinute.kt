package org.snakeskin.units.measure.velocity.angular

import org.snakeskin.units.AngularVelocityUnit

/**
 * @author Cameron Earle
 * @version 7/15/18
 *
 */
class AngularVelocityMeasureRevolutionsPerMinute(override val value: Double): AngularVelocityMeasure {
    companion object {
        const val REVOLUTIONS_PER_MINUTE_TO_REVOLUTIONS_PER_SECOND = 1 / 60.0
        const val REVOLUTIONS_PER_MINUTE_TO_RADIANS_PER_SECOND = 2 * Math.PI / 60.0
        const val REVOLUTIONS_PER_MINUTE_TO_DEGREES_PER_SECOND = 6.0
    }

    override val unit: AngularVelocityUnit
        get() = AngularVelocityUnit.Standard.REVOLUTIONS_PER_MINUTE

    override fun toUnit(unit: AngularVelocityUnit): AngularVelocityMeasure {
        return when (unit) {
            AngularVelocityUnit.Standard.REVOLUTIONS_PER_MINUTE -> this
            AngularVelocityUnit.Standard.REVOLUTIONS_PER_SECOND -> AngularVelocityMeasureRevolutionsPerSecond(value * REVOLUTIONS_PER_MINUTE_TO_REVOLUTIONS_PER_SECOND)
            AngularVelocityUnit.Standard.RADIANS_PER_SECOND -> AngularVelocityMeasureRadiansPerSecond(value * REVOLUTIONS_PER_MINUTE_TO_RADIANS_PER_SECOND)
            AngularVelocityUnit.Standard.DEGREES_PER_SECOND -> AngularVelocityMeasureDegreesPerSecond(value * REVOLUTIONS_PER_MINUTE_TO_DEGREES_PER_SECOND)
            else -> unit.convert(this)
        }
    }
}