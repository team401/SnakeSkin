package org.snakeskin.units.measure.velocity.angular

import org.snakeskin.units.AngularVelocityUnit

/**
 * @author Cameron Earle
 * @version 7/15/18
 *
 */
class AngularVelocityMeasureRadiansPerSecond(override val value: Double): AngularVelocityMeasure {
    companion object {
        const val RADIANS_PER_SECOND_TO_REVOLUTIONS_PER_SECOND = 1 / (2 * Math.PI)
        const val RADIANS_PER_SECOND_TO_REVOLUTIONS_PER_MINUTE = 30.0 / Math.PI
        const val RADIANS_PER_SECOND_TO_DEGREES_PER_SECOND = 180.0 / Math.PI
    }

    override val unit: AngularVelocityUnit
        get() = AngularVelocityUnit.Standard.RADIANS_PER_SECOND

    override fun toUnit(unit: AngularVelocityUnit): AngularVelocityMeasure {
        return when (unit) {
            AngularVelocityUnit.Standard.RADIANS_PER_SECOND -> this
            AngularVelocityUnit.Standard.REVOLUTIONS_PER_SECOND -> AngularVelocityMeasureRevolutionsPerSecond(value * RADIANS_PER_SECOND_TO_REVOLUTIONS_PER_SECOND)
            AngularVelocityUnit.Standard.REVOLUTIONS_PER_MINUTE -> AngularVelocityMeasureRevolutionsPerMinute(value * RADIANS_PER_SECOND_TO_REVOLUTIONS_PER_MINUTE)
            AngularVelocityUnit.Standard.DEGREES_PER_SECOND -> AngularVelocityMeasureDegreesPerSecond(value * RADIANS_PER_SECOND_TO_DEGREES_PER_SECOND)
            else -> unit.convert(this)
        }
    }
}