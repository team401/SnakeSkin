package org.snakeskin.units.measure.distance.angular

import org.snakeskin.units.AngularDistanceUnit

/**
 * @author Cameron Earle
 * @version 7/15/2018
 *
 * TODO Class to be inlined in Kotlin 1.3
 */
/*inline*/ class AngularDistanceMeasureRevolutions(override val value: Double): AngularDistanceMeasure {
    companion object {
        const val REVOLUTIONS_TO_RADIANS = 2 * Math.PI
        const val REVOLUTIONS_TO_DEGREES = 360.0
    }

    override val unit: AngularDistanceUnit
        get() = AngularDistanceUnit.REVOLUTIONS

    override fun toUnit(unit: AngularDistanceUnit): AngularDistanceMeasure {
        return when (unit) {
            AngularDistanceUnit.REVOLUTIONS -> this
            AngularDistanceUnit.RADIANS -> AngularDistanceMeasureRadians(value * REVOLUTIONS_TO_RADIANS)
            AngularDistanceUnit.DEGREES -> AngularDistanceMeasureDegrees(value * REVOLUTIONS_TO_DEGREES)
        }
    }

}