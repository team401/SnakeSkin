package org.snakeskin.component.provider

/**
 * Represents a component that provides basic percent output control
 */
interface IPercentOutputMotorControlProvider {
    /**
     * Sets the percent output of this component to the specified value
     * @param percentOut The percent output to apply, scaled from [-1.0, 1.0]
     */
    fun setPercentOutput(percentOut: Double)

    /**
     * Returns the percent output that this component is currently applying
     */
    fun getPercentOutput(): Double

    /**
     * Returns the input voltage to this component.
     * Depending on the implementation, this could be reading from the PDP VBus
     */
    fun getInputVoltage(): Double

    /**
     * Returns the output voltage from this component.
     * Depending on the implementation, this could be using the PDP VBus to approximate the output voltage
     */
    fun getOutputVoltage(): Double

    /**
     * Sets the percent output of this component to zero.  Depending on the configuration of the motor controller,
     * this could cause it to either coast or brake to a stop.
     */
    fun stop()
}