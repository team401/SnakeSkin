package org.snakeskin.units.measure.distance.angular

import org.snakeskin.units.AngularDistanceUnit

/**
 * @author Cameron Earle
 * @version 7/15/2018
 *
 * TODO Class to be inlined in Kotlin 1.3
 */
/*inline*/ class AngularDistanceMeasureDegrees(override val value: Double): AngularDistanceMeasure {
    companion object {
        const val DEGREES_TO_REVOLUTIONS = 1 / 360.0
        const val DEGREES_TO_RADIANS = Math.PI / 180.0
    }

    override val unit: AngularDistanceUnit
        get() = AngularDistanceUnit.DEGREES

    override fun toUnit(unit: AngularDistanceUnit): AngularDistanceMeasure {
        return when (unit) {
            AngularDistanceUnit.DEGREES -> this
            AngularDistanceUnit.REVOLUTIONS -> AngularDistanceMeasureRevolutions(value * DEGREES_TO_REVOLUTIONS)
            AngularDistanceUnit.RADIANS -> AngularDistanceMeasureRadians(value * DEGREES_TO_RADIANS)
        }
    }

}