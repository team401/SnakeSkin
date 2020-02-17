package org.snakeskin.component.provider

import org.snakeskin.measure.distance.angular.AngularDistanceMeasureDegrees

/**
 * Represents a component that can provide a pitch value, in degrees.
 */
interface IPitchProvider {
    /**
     * Returns the current heading in degrees
     */
    fun getPitch(): AngularDistanceMeasureDegrees
}