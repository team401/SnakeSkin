package org.snakeskin.component

/**
 * CTRE devices require arbitrary feedforward voltages to be given in percent output.
 * This enum provides the possible modes for scaling an input voltage on the primary controller side
 * before sending it to the device.
 */
enum class FeedforwardScalingMode {
    /**
     * Scales the desired feedforward voltage by a constant 12 volts.  This can be used in conjunction with
     * the device's voltage compensation mode to ensure the correct voltage is met
     */
    SCALE_12V,

    /**
     * Scales the desired feedforward voltage by the measured input voltage.  This requires a call to getInputVoltage()
     * which may increase CAN network utilization
     */
    SCALE_VBUS
}