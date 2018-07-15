package org.snakeskin.units.measure.velocity.angular

import org.snakeskin.units.AngularVelocityUnit

/**
 * @author Cameron Earle
 * @version 7/15/18
 *
 * TODO Class to be inlined in Kotlin 1.3
 */
/*inline*/ class AngularVelocityMeasureRevolutionsPerSecond(override val value: Double): AngularVelocityMeasure {
    companion object {
        const val REVOLUTIONS_PER_SECOND_TO_REVOLUTIONS_PER_MINUTE = 60.0
        const val REVOLUTIONS_PER_SECOND_TO_RADIANS_PER_SECOND = 2 * Math.PI
        const val REVOLUTIONS_PER_SECOND_TO_DEGREES_PER_SECOND = 360.0
    }

    override val unit: AngularVelocityUnit
        get() = AngularVelocityUnit.REVOLUTIONS_PER_SECOND

    override fun toUnit(unit: AngularVelocityUnit): AngularVelocityMeasure {
        return when (unit) {
            AngularVelocityUnit.REVOLUTIONS_PER_SECOND -> this
            AngularVelocityUnit.REVOLUTIONS_PER_MINUTE -> AngularVelocityMeasureRevolutionsPerMinute(value * REVOLUTIONS_PER_SECOND_TO_REVOLUTIONS_PER_MINUTE)
            AngularVelocityUnit.RADIANS_PER_SECOND -> AngularVelocityMeasureRadiansPerSecond(value * REVOLUTIONS_PER_SECOND_TO_RADIANS_PER_SECOND)
            AngularVelocityUnit.DEGREES_PER_SECOND -> AngularVelocityMeasureDegreesPerSecond(value * REVOLUTIONS_PER_SECOND_TO_DEGREES_PER_SECOND)
        }
    }
}