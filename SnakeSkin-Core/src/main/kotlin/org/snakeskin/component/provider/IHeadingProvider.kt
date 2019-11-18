package org.snakeskin.component.provider

import org.snakeskin.measure.distance.angular.AngularDistanceMeasureDegrees

/**
 * Represents a component that can provide a heading value, in degrees.
 * The range for the provided heading will depend on the the underlying implementation.
 * No guarantees are made about the range of this value, or how it wraps.  Consumers of these classes
 * should make sure to perform any necessary wrapping themselves.
 */
interface IHeadingProvider {
    /**
     * Sets the current heading to the value specified
     */
    fun setHeading(value: AngularDistanceMeasureDegrees)

    /**
     * Returns the current heading in degrees
     */
    fun getHeading(): AngularDistanceMeasureDegrees
}