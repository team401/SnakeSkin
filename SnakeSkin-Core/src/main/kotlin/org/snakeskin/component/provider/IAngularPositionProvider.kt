package org.snakeskin.component.provider

import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRadians

/**
 * Represents a component that can provide rotational position data
 */
interface IAngularPositionProvider {
    /**
     * Returns the rotational position of the component in radians
     */
    fun getAngularPosition(): AngularDistanceMeasureRadians

    /**
     * Sets the rotational position of the component to the specified angle in radians
     * Note: Implementations may choose to simply set the distance to zero instead of honoring the passed parameter.
     * Check the docs on the specific implementation class to see if this is the case
     */
    fun setAngularPosition(angle: AngularDistanceMeasureRadians)
}