package org.snakeskin.component.provider

/**
 * Represents a component that can provide data about an input voltage
 */
interface IInputVoltageProvider {
    /**
     * Returns the output voltage of the component in volts
     * Note: This will return 0 if the component does not output any voltage (e.g. the roboRIO voltage monitor)
     */
    fun getInputVoltage(): Double
}