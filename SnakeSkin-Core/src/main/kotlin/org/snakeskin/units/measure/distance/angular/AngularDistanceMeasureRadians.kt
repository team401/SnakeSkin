package org.snakeskin.units.measure.distance.angular

import org.snakeskin.units.AngularDistanceUnit

/**
 * @author Cameron Earle
 * @version 7/15/2018
 *
 * TODO Class to be inlined in Kotlin 1.3
 */
/*inline*/ class AngularDistanceMeasureRadians(override val value: Double): AngularDistanceMeasure {
    companion object {
        const val RADIANS_TO_REVOLUTIONS = 1 / (2 * Math.PI)
        const val RADIANS_TO_DEGREES = 180.0 / Math.PI
    }

    override val unit: AngularDistanceUnit
        get() = AngularDistanceUnit.RADIANS

    override fun toUnit(unit: AngularDistanceUnit): AngularDistanceMeasure {
        return when (unit) {
            AngularDistanceUnit.RADIANS -> this
            AngularDistanceUnit.REVOLUTIONS -> AngularDistanceMeasureRevolutions(value * RADIANS_TO_REVOLUTIONS)
            AngularDistanceUnit.DEGREES -> AngularDistanceMeasureDegrees(value * RADIANS_TO_DEGREES)
        }
    }

}