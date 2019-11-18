package org.snakeskin.component.provider

/**
 * Represents a component that can provide data about input and output voltages
 */
interface IVoltageProvider {
    /**
     * Returns the input voltage of the component in volts
     */
    fun getInputVoltage(): Double

    /**
     * Returns the output voltage of the component in volts
     * Note: This will return 0 if the component does not output any voltage (e.g. the roboRIO voltage monitor)
     */
    fun getOutputVoltage(): Double
}