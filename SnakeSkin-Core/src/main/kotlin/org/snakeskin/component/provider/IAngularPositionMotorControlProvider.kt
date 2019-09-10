package org.snakeskin.component.provider

import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRevolutions

/**
 * Represents a component that can provide angular position control
 */
interface IAngularPositionMotorControlProvider {
    /**
     * Sets the angular position setpoint to the specified value
     * @param setpoint The setpoint to configure
     * @param ffVolts Optional feedforward voltage to apply as a sum to the control output
     */
    fun setAngularPositionSetpoint(setpoint: AngularDistanceMeasureRevolutions, ffVolts: Double = 0.0)
}