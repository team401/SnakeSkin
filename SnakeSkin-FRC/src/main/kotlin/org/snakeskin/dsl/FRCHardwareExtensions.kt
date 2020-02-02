package org.snakeskin.dsl

import edu.wpi.first.wpilibj.CounterBase
import edu.wpi.first.wpilibj.DigitalInput
import edu.wpi.first.wpilibj.Encoder
import org.snakeskin.component.IDIOEncoderDevice
import org.snakeskin.component.IDigitalInputChannel
import org.snakeskin.component.impl.HardwareDIOEncoderDevice
import org.snakeskin.component.impl.HardwareDigitalInputChannel
import org.snakeskin.component.impl.NullDIOEncoderDevice
import org.snakeskin.component.impl.NullDigitalInputChannel
import org.snakeskin.runtime.SnakeskinPlatform
import org.snakeskin.runtime.SnakeskinRuntime

/**
 * Creates a new DIO Encoder device object.
 * @param aChannel The DIO ID of the A channel of the encoder
 * @param bChannel The DIO ID of the B channel of the encoder
 * @param sensorTicksPerRevolution Number of sensor ticks per one revolution of the connected sensor
 * @param invert True to flip the direction of the encoder, false otherwise
 * @param halMock If true, WPI HAL mocks will be used in WPI Sim mode.  If false, mockProducer will be called.
 * @param mockProducer Function which returns a mock object representing the device, used for emulating hardware
 */
inline fun Hardware.createDIOEncoder(
        aChannel: Int,
        bChannel: Int,
        sensorTicksPerRevolution: Double,
        invert: Boolean = false,
        halMock: Boolean = false,
        mockProducer: () -> IDIOEncoderDevice = { throw NotImplementedError("No mock DIO Encoder implementation provided") }
) = when (SnakeskinRuntime.platform) {
    SnakeskinPlatform.UNDEFINED -> NullDIOEncoderDevice.INSTANCE
    SnakeskinPlatform.FRC_ROBORIO -> HardwareDIOEncoderDevice(Encoder(aChannel, bChannel, invert, CounterBase.EncodingType.k4X), sensorTicksPerRevolution)
    SnakeskinPlatform.FRC_WPISIM -> if (halMock) HardwareDIOEncoderDevice(Encoder(aChannel, bChannel, invert, CounterBase.EncodingType.k4X), sensorTicksPerRevolution) else mockProducer()
    else -> mockProducer()
}

/**
 * Creates a new digital input channel object.
 * @param channel The ID of the channel
 * @param halMock If true, WPI HAL mocks will be used in WPI Sim mode.  If false, mockProducer will be called.
 * @param mockProducer Function which returns a mock object representing the device, used for emulating hardware
 */
inline fun Hardware.createDigitalInputChannel(
        channel: Int,
        halMock: Boolean = false,
        mockProducer: () -> IDigitalInputChannel = { throw NotImplementedError("No mock digital input implementation provided") }
) = when (SnakeskinRuntime.platform) {
    SnakeskinPlatform.UNDEFINED -> NullDigitalInputChannel.INSTANCE
    SnakeskinPlatform.FRC_ROBORIO -> HardwareDigitalInputChannel(DigitalInput(channel))
    SnakeskinPlatform.FRC_WPISIM -> if (halMock) HardwareDigitalInputChannel(DigitalInput(channel)) else mockProducer()
    else -> mockProducer()
}


/**
 * Allows access to hardware device functions of a DIO Encoder device
 * @param dioEncoderDevice The DIO Encoder device object
 * @param action The action to run on the hardware.  If the runtime is not hardware, the action will not be run
 */
inline fun useHardware(dioEncoderDevice: IDIOEncoderDevice, action: Encoder.() -> Unit) {
    if (dioEncoderDevice is HardwareDIOEncoderDevice) {
        action(dioEncoderDevice.device)
    }
}

/**
 * Allows access to hardware device functions of a digital input channel
 * @param digitalInputChannel The digital input channel object
 * @param action The action to run on the hardware.  If the runtime is not hardware, the action will not be run
 */
inline fun useHardware(digitalInputChannel: IDigitalInputChannel, action: DigitalInput.() -> Unit) {
    if (digitalInputChannel is HardwareDigitalInputChannel) {
        action(digitalInputChannel.channel)
    }
}