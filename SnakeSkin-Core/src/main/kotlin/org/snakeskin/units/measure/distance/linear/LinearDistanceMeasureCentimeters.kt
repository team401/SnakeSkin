package org.snakeskin.units.measure.distance.linear

import org.snakeskin.units.LinearDistanceUnit
import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasure

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 * TODO Class to be inlined in Kotlin 1.3
 */

/*inline*/ class LinearDistanceMeasureCentimeters(override val value: Double): LinearDistanceMeasure {
    companion object {
        const val CENTIMETERS_TO_METERS = 0.01
        const val CENTIMETERS_TO_INCHES = 0.393701
        const val CENTIMETERS_TO_FEET = 0.0328084
    }

    override val unit: LinearDistanceUnit
        get() = LinearDistanceUnit.CENTIMETERS

    override fun inUnit(unit: LinearDistanceUnit): LinearDistanceMeasure {
        return when (unit) {
            LinearDistanceUnit.CENTIMETERS -> this
            LinearDistanceUnit.METERS -> LinearDistanceMeasureMeters(value * CENTIMETERS_TO_METERS)
            LinearDistanceUnit.INCHES -> LinearDistanceMeasureInches(value * CENTIMETERS_TO_INCHES)
            LinearDistanceUnit.FEET -> LinearDistanceMeasureFeet(value * CENTIMETERS_TO_FEET)
        }
    }

    override fun toAngularDistance(diameter: Double): AngularDistanceMeasure {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}