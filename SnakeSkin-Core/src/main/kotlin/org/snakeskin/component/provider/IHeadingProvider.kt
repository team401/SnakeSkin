package org.snakeskin.component.provider

import org.snakeskin.measure.distance.angular.AngularDistanceMeasureDegrees

/**
 * Represents a component that can provide a heading value, in degrees.
 * Note that returned headings should be "180 wrapped", meaning they do not continue counting past +/- 180 degrees
 */
interface IHeadingProvider {
    /**
     * Sets the current heading to the value specified
     */
    fun setHeading(value: AngularDistanceMeasureDegrees)

    /**
     * Returns the current heading in degrees, wrapped at the 180 mark
     */
    fun getHeading(): AngularDistanceMeasureDegrees
}