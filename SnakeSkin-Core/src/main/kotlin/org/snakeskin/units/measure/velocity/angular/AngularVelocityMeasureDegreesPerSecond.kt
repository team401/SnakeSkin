package org.snakeskin.units.measure.velocity.angular

import org.snakeskin.units.AngularVelocityUnit

/**
 * @author Cameron Earle
 * @version 7/15/18
 *
 * TODO Class to be inlined in Kotlin 1.3
 */
/*inline*/ class AngularVelocityMeasureDegreesPerSecond(override val value: Double): AngularVelocityMeasure {
    companion object {
        const val DEGREES_PER_SECOND_TO_REVOLUTIONS_PER_SECOND = 1 / 360.0
        const val DEGREES_PER_SECOND_TO_REVOLUTIONS_PER_MINUTE = 1 / 6.0
        const val DEGREES_PER_SECOND_TO_RADIANS_PER_SECOND = Math.PI / 180.0
    }

    override val unit: AngularVelocityUnit
        get() = AngularVelocityUnit.DEGREES_PER_SECOND

    override fun toUnit(unit: AngularVelocityUnit): AngularVelocityMeasure {
        return when (unit) {
            AngularVelocityUnit.DEGREES_PER_SECOND -> this
            AngularVelocityUnit.REVOLUTIONS_PER_SECOND -> AngularVelocityMeasureRevolutionsPerSecond(value * DEGREES_PER_SECOND_TO_REVOLUTIONS_PER_SECOND)
            AngularVelocityUnit.REVOLUTIONS_PER_MINUTE -> AngularVelocityMeasureRevolutionsPerMinute(value * DEGREES_PER_SECOND_TO_REVOLUTIONS_PER_MINUTE)
            AngularVelocityUnit.RADIANS_PER_SECOND -> AngularVelocityMeasureRadiansPerSecond(value * DEGREES_PER_SECOND_TO_RADIANS_PER_SECOND)
        }
    }
}