package org.snakeskin.component.provider

import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRadiansPerSecond

/**
 * Represents a component that can provide rotational velocity data
 */
interface IAngularVelocityProvider {
    /**
     * Returns the rotational velocity of the component in radians per second
     */
    fun getAngularVelocity(): AngularVelocityMeasureRadiansPerSecond
}