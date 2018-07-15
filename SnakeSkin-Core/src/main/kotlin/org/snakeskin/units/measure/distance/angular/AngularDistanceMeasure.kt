package org.snakeskin.units.measure.distance.angular

import org.snakeskin.units.AngularDistanceUnit
import org.snakeskin.units.measure.Measure
import org.snakeskin.units.measure.distance.linear.LinearDistanceMeasure

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 */
interface AngularDistanceMeasure: Measure<AngularDistanceUnit, AngularDistanceMeasure> {
    fun toLinearDistance(diameter: Double): LinearDistanceMeasure
}