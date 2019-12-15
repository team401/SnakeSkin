package org.snakeskin.component

/**
 * Options for reading output voltage from the SPARK MAX
 * The SPARK MAX does not provide a direct way to read output voltage, so we need to multiply the output percent
 * with a bus voltage.  This enum lets the user select which voltage source to use
 */
enum class OutputVoltageReadingMode {
    /**
     * Uses SnakeskinRuntime.voltage to get the system bus voltage.  This is fast but potentially inaccurate
     */
    MultiplyVbusSystem,

    /**
     * Uses the bus voltage reading from the device to get system bus voltage.  This requires a call to the input
     * voltage function of the device, and CAN frames to be sent.
     */
    MultiplyVbusDevice
}