package org.snakeskin.component.provider

import org.snakeskin.measure.distance.angular.AngularDistanceMeasureDegrees

/**
 * Represents a component that can provide a roll value, in degrees.
 */
interface IRollProvider {
    /**
     * Returns the current heading in degrees
     */
    fun getRoll(): AngularDistanceMeasureDegrees
}