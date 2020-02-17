package org.snakeskin.component.provider

import org.snakeskin.measure.distance.linear.LinearDistanceMeasureInches

/**
 * Represents a component that can provide linear position data
 */
interface ILinearPositionProvider {
    /**
     * Returns the linear position of the component in inches
     */
    fun getLinearPosition(): LinearDistanceMeasureInches

    /**
     * Sets the linear position of the component to the specified angle in inches
     * Note: Implementations may choose to simply set the distance to zero instead of honoring the passed parameter.
     * Check the docs on the specific implementation class to see if this is the case
     */
    fun setLinearPosition(position: LinearDistanceMeasureInches)
}