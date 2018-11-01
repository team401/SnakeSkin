package org.snakeskin.units.measure.distance.angular

import org.snakeskin.units.AngularDistanceUnit

/**
 * @author Cameron Earle
 * @version 7/15/2018
 *
 */
class AngularDistanceMeasureDegrees(override val value: Double): AngularDistanceMeasure {
    companion object {
        const val DEGREES_TO_REVOLUTIONS = 1 / 360.0
        const val DEGREES_TO_RADIANS = Math.PI / 180.0
    }

    override val unit: AngularDistanceUnit
        get() = AngularDistanceUnit.Standard.DEGREES

    override fun toUnit(unit: AngularDistanceUnit): AngularDistanceMeasure {
        return when (unit) {
            AngularDistanceUnit.Standard.DEGREES -> this
            AngularDistanceUnit.Standard.REVOLUTIONS -> AngularDistanceMeasureRevolutions(value * DEGREES_TO_REVOLUTIONS)
            AngularDistanceUnit.Standard.RADIANS -> AngularDistanceMeasureRadians(value * DEGREES_TO_RADIANS)
            else -> unit.convert(this)
        }
    }

}