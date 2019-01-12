package org.snakeskin.units.measure.velocity.angular

import org.snakeskin.units.AngularVelocityUnit

/**
 * @author Cameron Earle
 * @version 7/15/18
 *
 */
class AngularVelocityMeasureDegreesPerSecond(override val value: Double): AngularVelocityMeasure {
    companion object {
        const val DEGREES_PER_SECOND_TO_REVOLUTIONS_PER_SECOND = 1 / 360.0
        const val DEGREES_PER_SECOND_TO_REVOLUTIONS_PER_MINUTE = 1 / 6.0
        const val DEGREES_PER_SECOND_TO_RADIANS_PER_SECOND = Math.PI / 180.0
    }

    override val unit: AngularVelocityUnit
        get() = AngularVelocityUnit.Standard.DEGREES_PER_SECOND

    override fun toUnit(unit: AngularVelocityUnit): AngularVelocityMeasure {
        return when (unit) {
            AngularVelocityUnit.Standard.DEGREES_PER_SECOND -> this
            AngularVelocityUnit.Standard.REVOLUTIONS_PER_SECOND -> AngularVelocityMeasureRevolutionsPerSecond(value * DEGREES_PER_SECOND_TO_REVOLUTIONS_PER_SECOND)
            AngularVelocityUnit.Standard.REVOLUTIONS_PER_MINUTE -> AngularVelocityMeasureRevolutionsPerMinute(value * DEGREES_PER_SECOND_TO_REVOLUTIONS_PER_MINUTE)
            AngularVelocityUnit.Standard.RADIANS_PER_SECOND -> AngularVelocityMeasureRadiansPerSecond(value * DEGREES_PER_SECOND_TO_RADIANS_PER_SECOND)
            else -> unit.convert(this)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other is AngularVelocityMeasure) {
            val converted = other.toUnit(unit).value
            return converted == value
        }
        return false
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun toString(): String {
        return "$value deg/s"
    }
}