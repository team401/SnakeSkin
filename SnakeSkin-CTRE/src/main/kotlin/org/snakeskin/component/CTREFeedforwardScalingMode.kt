package org.snakeskin.component

/**
 * CTRE devices require arbitrary feedforward voltages to be given in percent output.
 * This enum provides the possible modes for scaling an input voltage on the primary controller side
 * before sending it to the device.
 */
enum class CTREFeedforwardScalingMode {
    /**
     * Scales the desired feedforward voltage by a constant 12 volts.  This can be used in conjunction with
     * the device's voltage compensation mode to ensure the correct voltage is met
     */
    Scale12V,

    /**
     * Scales the desired feedforward voltage by the measured bus voltage from the robot controller.
     * This makes a call to SnakeskinRuntime.voltage, which is fast but may not be as accurate as the device voltage
     */
    ScaleVbusSystem,

    /**
     * Scales the desired feedforward voltage by the measured input voltage from the device.
     * This requires a call to getInputVoltage() which may increase CAN network utilization
     */
    ScaleVbusDevice
}