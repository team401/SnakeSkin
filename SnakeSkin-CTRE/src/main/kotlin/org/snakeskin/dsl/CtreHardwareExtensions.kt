package org.snakeskin.dsl

import com.ctre.phoenix.motorcontrol.can.TalonFX
import com.ctre.phoenix.motorcontrol.can.TalonSRX
import com.ctre.phoenix.motorcontrol.can.VictorSPX
import com.ctre.phoenix.sensors.CANCoder
import com.ctre.phoenix.sensors.PigeonIMU
import org.snakeskin.component.*
import org.snakeskin.component.impl.*
import org.snakeskin.runtime.SnakeskinPlatform
import org.snakeskin.runtime.SnakeskinRuntime

/**
 * Creates a new Talon SRX device object.
 * @param hardwareId THe CAN ID of the Talon SRX
 * @param sensorTicksPerRevolution Number of sensor ticks per one revolution of the connected sensor
 * @param ffMode The mode to use to scale feedforward voltages sent to the motor
 * @param mockProducer Function which returns a mock object representing the device, used for emulating hardware
 */
inline fun Hardware.createTalonSRX(
        hardwareId: Int,
        sensorTicksPerRevolution: Double = 4096.0,
        ffMode: CTREFeedforwardScalingMode = CTREFeedforwardScalingMode.ScaleVbusSystem,
        mockProducer: () -> ITalonSrxDevice = { throw NotImplementedError("No mock TalonSRX implementation provided") }
) = when (SnakeskinRuntime.platform) {
    SnakeskinPlatform.UNDEFINED -> NullTalonSrxDevice.INSTANCE
    SnakeskinPlatform.FRC_ROBORIO -> HardwareTalonSrxDevice(TalonSRX(hardwareId), sensorTicksPerRevolution, ffMode)
    else -> mockProducer()
}

/**
 * Creates a new Victor SPX device object.
 * @param hardwareId The CAN ID of the Victor SPX
 * @param mockProducer Function which returns a mock object representing the device, used for emulating hardware
 */
inline fun Hardware.createVictorSPX(
        hardwareId: Int,
        mockProducer: () -> IVictorSpxDevice = { throw NotImplementedError("No mock VictorSPX implementation provided") }
) = when (SnakeskinRuntime.platform) {
    SnakeskinPlatform.UNDEFINED -> NullVictorSpxDevice.INSTANCE
    SnakeskinPlatform.FRC_ROBORIO -> HardwareVictorSpxDevice(VictorSPX(hardwareId))
    else -> mockProducer()
}

/**
 * Creates a new Talon FX device object.
 * @param hardwareId The CAN ID of the Talon FX
 * @param mockProducer Function which returns a mock object representing the device, used for emulating hardware
 */
inline fun Hardware.createTalonFX(
        hardwareId: Int,
        ffMode: CTREFeedforwardScalingMode = CTREFeedforwardScalingMode.ScaleVbusSystem,
        mockProducer: () -> ITalonFxDevice = { throw NotImplementedError("No mock TalonFX implementation provided") }
) = when (SnakeskinRuntime.platform) {
    SnakeskinPlatform.UNDEFINED -> NullTalonFxDevice.INSTANCE
    SnakeskinPlatform.FRC_ROBORIO -> HardwareTalonFxDevice(TalonFX(hardwareId), ffMode)
    else -> mockProducer()
}

/**
 * Creates a new CAN connected Pigeon IMU device object.
 * @param hardwareId The CAN ID of the Pigeon IMU
 * @param mockProducer Function which returns a mock object representing the device, used for emulating hardware
 */
inline fun Hardware.createCANPigeonIMU(
        hardwareId: Int,
        mockProducer: () -> IPigeonImuDevice = { throw NotImplementedError("No mock Pigeon IMU implementation provided") }
) = when (SnakeskinRuntime.platform) {
    SnakeskinPlatform.UNDEFINED -> NullPigeonImuDevice.INSTANCE
    SnakeskinPlatform.FRC_ROBORIO -> HardwarePigeonImuDevice(PigeonIMU(hardwareId))
    else -> mockProducer()
}

/**
 * Creates a new Talon connected Pigeon IMU device object.
 * @param talonDevice The device object of the Talon SRX which the Pigeon is connected to
 * @param mockProducer Function which returns a mock object representing the device, used for emulating hardware
 */
inline fun Hardware.createTalonPigeonIMU(
        talonDevice: ITalonSrxDevice,
        mockProducer: () -> IPigeonImuDevice = { throw NotImplementedError("No mock Pigeon IMU implementation provided") }
) = when (SnakeskinRuntime.platform) {
    SnakeskinPlatform.UNDEFINED -> NullPigeonImuDevice.INSTANCE
    SnakeskinPlatform.FRC_ROBORIO -> HardwarePigeonImuDevice(PigeonIMU((talonDevice as HardwareTalonSrxDevice).device))
    else -> mockProducer()
}

/**
 * Creates a new CANCoder device object.
 * @param hardwareId The CAN ID of the CANCoder
 * @param mockProducer Function which returns a mock object representing the device, used for emulating hardware
 *
 * Note that it is assumed that the underlying CANCoder object will be left in its default configuration of degrees
 * for the angular distance unit, and seconds for the time unit.  Changes to this low-level configuration will result
 * in invalid values being returned by the accessor functions of the device object.
 */
inline fun Hardware.createCANCoder(
        hardwareId: Int,
        mockProducer: () -> ICanCoderDevice = { throw NotImplementedError("No mock CANCoder implementation provided") }
) = when (SnakeskinRuntime.platform) {
    SnakeskinPlatform.UNDEFINED -> NullCanCoderDevice.INSTANCE
    SnakeskinPlatform.FRC_ROBORIO -> HardwareCanCoderDevice(CANCoder(hardwareId))
    else -> mockProducer()
}

/**
 * Allows access to hardware device functions of a Talon SRX device
 * @param talonSrxDevice The Talon SRX device object
 * @param action The action to run on the hardware.  If the runtime is not hardware, the action will not be run
 */
inline fun useHardware(talonSrxDevice: ITalonSrxDevice, action: TalonSRX.() -> Unit) {
    if (talonSrxDevice is HardwareTalonSrxDevice) {
        action(talonSrxDevice.device)
    }
}

/**
 * Allows access to hardware device functions of a Victor SPX device
 * @param victorSpxDevice The Victor SPX device object
 * @param action The action to run on the hardware.  If the runtime is not hardware, the action will not be run
 */
inline fun useHardware(victorSpxDevice: IVictorSpxDevice, action: VictorSPX.() -> Unit) {
    if (victorSpxDevice is HardwareVictorSpxDevice) {
        action(victorSpxDevice.device)
    }
}

/**
 * Allows access to hardware device functions of a Talon FX device
 * @param talonFxDevice The Talon FX device object
 * @param action The action to run on the hardware.  If the runtime is not hardware, the action will not be run
 */
inline fun useHardware(talonFxDevice: ITalonFxDevice, action: TalonFX.() -> Unit) {
    if (talonFxDevice is HardwareTalonFxDevice) {
        action(talonFxDevice.device)
    }
}

/**
 * Allows access to hardware device functions of a Pigeon IMU device
 * @param pigeonImuDevice The Pigeon IMU device object
 * @param action The action to run on the hardware.  If the runtime is not hardware, the action will not be run
 */
inline fun useHardware(pigeonImuDevice: IPigeonImuDevice, action: PigeonIMU.() -> Unit) {
    if (pigeonImuDevice is HardwarePigeonImuDevice) {
        action(pigeonImuDevice.device)
    }
}

/**
 * Allows access to hardware device functions of a CANCoder device
 * @param canCoderDevice The CANCoder device object
 * @param action The action to run on the hardware.  If the runtime is not hardware, the action will not be run
 */
inline fun useHardware(canCoderDevice: ICanCoderDevice, action: CANCoder.() -> Unit) {
    if (canCoderDevice is HardwareCanCoderDevice) {
        action(canCoderDevice.device)
    }
}