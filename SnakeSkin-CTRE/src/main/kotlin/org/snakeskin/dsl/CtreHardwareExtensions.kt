package org.snakeskin.dsl

import com.ctre.phoenix.motorcontrol.can.TalonSRX
import com.ctre.phoenix.motorcontrol.can.VictorSPX
import org.snakeskin.component.FeedforwardScalingMode
import org.snakeskin.component.Hardware
import org.snakeskin.component.ITalonSrxDevice
import org.snakeskin.component.IVictorSpxDevice
import org.snakeskin.component.impl.HardwareTalonSrxDevice
import org.snakeskin.component.impl.HardwareVictorSpxDevice
import org.snakeskin.runtime.SnakeskinPlatform
import org.snakeskin.runtime.SnakeskinRuntime

/**
 * Creates a new Talon SRX device object.
 * @param sensorTicksPerRevolution Number of sensor ticks per one revolution of the connected sensor
 * @param ffMode The mode to use to scale feedforward voltages sent to the motor
 *
 * @param mockProducer Function which returns a mock object representing the device, used for emulating hardware
 * @param hardwareProducer Function which returns a hardware TalonSRX object from CTRE Phoenix
 */
inline fun Hardware.createTalonSrx(
        hardwareId: Int,
        sensorTicksPerRevolution: Double = 4096.0,
        ffMode: FeedforwardScalingMode = FeedforwardScalingMode.ScaleVbusSystem,

        mockProducer: () -> ITalonSrxDevice = { throw NotImplementedError("No mock TalonSRX implementation provided") }
) = when (SnakeskinRuntime.platform) {
    SnakeskinPlatform.FRC_ROBORIO -> HardwareTalonSrxDevice(TalonSRX(hardwareId), sensorTicksPerRevolution, ffMode)
    else -> mockProducer()
}

/**
 * Creates a new Victor SPX device object.
 * @param mockProducer Function which returns a mock object representing the device, used for emulating hardware
 * @param hardwareProducer Function which returns a hardware VictorSPX object from CTRE Phoenix
 */
inline fun Hardware.createVictorSpx(
        hardwareId: Int,
        mockProducer: () -> IVictorSpxDevice = { throw NotImplementedError("No mock VictorSPX implementation provided") }
) = when (SnakeskinRuntime.platform) {
    SnakeskinPlatform.FRC_ROBORIO -> HardwareVictorSpxDevice(VictorSPX(hardwareId))
    else -> mockProducer()
}

/**
 * Allows access to hardware device functions of a Talon SRX device
 * @param talonSrxDevice The Talon SRX device object
 * @param action The action to run on the hardware.  If the runtime is not hardware, the action will not be run
 */
inline fun useHardware(talonSrxDevice: ITalonSrxDevice, action: TalonSRX.() -> Unit) {
    if (SnakeskinRuntime.platform == SnakeskinPlatform.FRC_ROBORIO) {
        action((talonSrxDevice as HardwareTalonSrxDevice).device)
    }
}

/**
 * Allows access to hardware device functions of a Victor SPX device
 * @param victorSpxDevice The Victor SPX device object
 * @param action The action to run on the hardware.  If the runtime is not hardware, the action will not be run
 */
inline fun useHardware(victorSpxDevice: IVictorSpxDevice, action: VictorSPX.() -> Unit) {
    if (SnakeskinRuntime.platform == SnakeskinPlatform.FRC_ROBORIO) {
        action((victorSpxDevice as HardwareVictorSpxDevice).device)
    }
}

fun test() {
    val leftSlave = Hardware.createVictorSpx(5)
    val leftMaster = Hardware.createTalonSrx(6)


    leftSlave.follow(leftMaster)

    useHardware(leftMaster) {
        configContinuousCurrentLimit(50)
    }
}