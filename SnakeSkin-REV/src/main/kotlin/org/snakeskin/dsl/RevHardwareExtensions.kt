package org.snakeskin.dsl

import com.revrobotics.CANSparkMax
import com.revrobotics.CANSparkMaxLowLevel
import org.snakeskin.component.Hardware
import org.snakeskin.component.ISparkMaxDevice
import org.snakeskin.component.SparkMaxOutputVoltageReadingMode
import org.snakeskin.component.impl.HardwareSparkMaxDevice
import org.snakeskin.component.impl.NullSparkMaxDevice
import org.snakeskin.runtime.SnakeskinPlatform
import org.snakeskin.runtime.SnakeskinRuntime

/**
 * Creates a new SPARK MAX device object in brushed mode.
 * @param hardwareId THe CAN ID of the SPARK MAX
 * @param encoderCpr Counts per rev of attached quadrature encoder, or 0 if no encoder is attached
 * @param voltageReadingMode The mode to read output voltage from the SPARK MAX
 * @param useAlternateEncoderPinout Whether or not to use the "alternate encoder" pinout
 * @param mockProducer Function which returns a mock object representing the device, used for emulating hardware
 */
inline fun Hardware.createBrushedSparkMax(
        hardwareId: Int,
        encoderCpr: Int = 0,
        voltageReadingMode: SparkMaxOutputVoltageReadingMode = SparkMaxOutputVoltageReadingMode.MultiplyVbusSystem,
        useAlternateEncoderPinout: Boolean = false,
        mockProducer: () -> ISparkMaxDevice = { throw NotImplementedError("No mock SPARK MAX implementation provided") }
) = when (SnakeskinRuntime.platform) {
    SnakeskinPlatform.UNDEFINED -> NullSparkMaxDevice.INSTANCE
    SnakeskinPlatform.FRC_ROBORIO -> HardwareSparkMaxDevice(CANSparkMax(
            hardwareId,
            CANSparkMaxLowLevel.MotorType.kBrushed
    ), voltageReadingMode, useAlternateEncoderPinout, encoderCpr)
    else -> mockProducer()
}

/**
 * Creates a new SPARK MAX device object in brushless mode, using the internal encoder.
 * @param hardwareId THe CAN ID of the SPARK MAX
 * @param voltageReadingMode The mode to read output voltage from the SPARK MAX
 * @param mockProducer Function which returns a mock object representing the device, used for emulating hardware
 */
inline fun Hardware.createBrushlessSparkMax(
        hardwareId: Int,
        voltageReadingMode: SparkMaxOutputVoltageReadingMode = SparkMaxOutputVoltageReadingMode.MultiplyVbusSystem,
        mockProducer: () -> ISparkMaxDevice = { throw NotImplementedError("No mock SPARK MAX implementation provided") }
) = when (SnakeskinRuntime.platform) {
    SnakeskinPlatform.UNDEFINED -> NullSparkMaxDevice.INSTANCE
    SnakeskinPlatform.FRC_ROBORIO -> HardwareSparkMaxDevice(CANSparkMax(
            hardwareId,
            CANSparkMaxLowLevel.MotorType.kBrushless
    ), voltageReadingMode, false)
    else -> mockProducer()
}

/**
 * Creates a new SPARK MAX device object in brushless mode, using an external encoder in the "alternate pinout".
 * @param hardwareId THe CAN ID of the SPARK MAX
 * @param encoderCpr Counts per rev of attached quadrature encoder
 * @param voltageReadingMode The mode to read output voltage from the SPARK MAX
 * @param mockProducer Function which returns a mock object representing the device, used for emulating hardware
 */
inline fun Hardware.createBrushlessSparkMaxWithEncoder(
        hardwareId: Int,
        encoderCpr: Int,
        voltageReadingMode: SparkMaxOutputVoltageReadingMode = SparkMaxOutputVoltageReadingMode.MultiplyVbusSystem,
        mockProducer: () -> ISparkMaxDevice = { throw NotImplementedError("No mock SPARK MAX implementation provided") }
) = when (SnakeskinRuntime.platform) {
    SnakeskinPlatform.UNDEFINED -> NullSparkMaxDevice.INSTANCE
    SnakeskinPlatform.FRC_ROBORIO -> HardwareSparkMaxDevice(CANSparkMax(
            hardwareId,
            CANSparkMaxLowLevel.MotorType.kBrushless
    ), voltageReadingMode, true, encoderCpr)
    else -> mockProducer()
}

/**
 * Allows access to hardware device functions of a SPARK MAX device
 * @param sparkMaxDevice The SPARK MAX device object
 * @param action The action to run on the hardware.  If the runtime is not hardware, the action will not be run
 */
inline fun useHardware(sparkMaxDevice: ISparkMaxDevice, action: CANSparkMax.() -> Unit) {
    if (SnakeskinRuntime.platform == SnakeskinPlatform.FRC_ROBORIO) {
        action((sparkMaxDevice as HardwareSparkMaxDevice).device)
    }
}

/**
 * Allows access to hardware device functions of multiple SPARK MAX devices
 * @param sparkMaxDevices The SPARK MAX device objects
 * @param action The action to run on the hardware.  If the runtime is not hardware, the action will not be run
 */
inline fun useHardware(vararg sparkMaxDevices: ISparkMaxDevice, action: CANSparkMax.() -> Unit) {
    if (SnakeskinRuntime.platform == SnakeskinPlatform.FRC_ROBORIO) {
        sparkMaxDevices.forEach {
            action((it as HardwareSparkMaxDevice).device)
        }
    }
}