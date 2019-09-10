package org.snakeskin.component.provider

import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRevolutions

/**
 * Represents a component that can provide rotational position data
 */
interface IAngularPositionProvider {
    /**
     * Returns the rotational position of the component in radians
     */
    fun getRotationalPosition(): AngularDistanceMeasureRevolutions

    /**
     * Sets the rotational position of the component to the specified angle in radians
     */
    fun setRotationalPosition(angle: AngularDistanceMeasureRevolutions)
}