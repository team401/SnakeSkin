package org.snakeskin.component.provider

import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRevolutionsPerSecond

/**
 * Represents a component that can provide control of angular velocity
 */
interface IAngularVelocityMotorControlProvider {
    /**
     * Sets the angular velocity setpoint of the component to the specified value.
     * @param setpoint The setpoint to configure
     * @param ffVolts Optional feedforward voltage to apply as a sum to the control output
     */
    fun setAngularVelocitySetpoint(setpoint: AngularVelocityMeasureRevolutionsPerSecond, ffVolts: Double = 0.0)
}