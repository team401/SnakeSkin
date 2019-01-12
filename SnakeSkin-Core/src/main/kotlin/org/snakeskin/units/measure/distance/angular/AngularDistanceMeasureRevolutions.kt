package org.snakeskin.units.measure.distance.angular

import org.snakeskin.units.AngularDistanceUnit

/**
 * @author Cameron Earle
 * @version 7/15/2018
 *
 */
class AngularDistanceMeasureRevolutions(override val value: Double): AngularDistanceMeasure {
    companion object {
        const val REVOLUTIONS_TO_RADIANS = 2 * Math.PI
        const val REVOLUTIONS_TO_DEGREES = 360.0
    }

    override val unit: AngularDistanceUnit
        get() = AngularDistanceUnit.Standard.REVOLUTIONS

    override fun toUnit(unit: AngularDistanceUnit): AngularDistanceMeasure {
        return when (unit) {
            AngularDistanceUnit.Standard.REVOLUTIONS -> this
            AngularDistanceUnit.Standard.RADIANS -> AngularDistanceMeasureRadians(value * REVOLUTIONS_TO_RADIANS)
            AngularDistanceUnit.Standard.DEGREES -> AngularDistanceMeasureDegrees(value * REVOLUTIONS_TO_DEGREES)
            else -> unit.convert(this)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other is AngularDistanceMeasure) {
            val converted = other.toUnit(unit).value
            return converted == value
        }
        return false
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun toString(): String {
        return "$value rev"
    }
}