package org.snakeskin.component.provider

import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRevolutions

/**
 * Represents a component that can provide profiled motion control, meaning it can execute a movement
 * while following both position and velocity constraints simultaneously
 */
interface IAngularProfileMotorControlProvider {
    /**
     * Sets the profile setpoint to the given value
     * @param setpoint The setpoint to configure
     * @param ffVolts Optional feedforward voltage to apply as a sum to the control output
     */
    fun setProfiledSetpoint(setpoint: AngularDistanceMeasureRevolutions, ffVolts: Double = 0.0)
}