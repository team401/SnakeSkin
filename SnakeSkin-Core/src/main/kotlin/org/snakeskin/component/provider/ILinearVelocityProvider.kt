package org.snakeskin.component.provider

import org.snakeskin.measure.velocity.linear.LinearVelocityMeasureInchesPerSecond

/**
 * Represents a component that can provide linear velocity data
 */
interface ILinearVelocityProvider {
    /**
     * Returns the linear velocity of the component in inches per second
     */
    fun getLinearVelocity(): LinearVelocityMeasureInchesPerSecond
}