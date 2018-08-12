package edu.wpi.first.wpilibj.hal

/**
 * @author Cameron Earle
 * @version 8/11/2018
 *
 * Values pulled from
 * https://github.com/wpilibsuite/allwpilib/blob/0ef9803363380c58804a0d885a7cc7ea8233a1ac/hal/src/main/native/sim/PortsInternal.h
 * on 8/11/2018
 */
object PortsJNI: JNIWrapper() {
    private const val kNumAccumulators = 2
    private const val kNumAnalogTriggers = 8
    private const val kNumAnalogInputs = 8
    private const val kNumAnalogOutputs = 2
    private const val kNumCounters = 8
    private const val kNumDigitalHeaders = 10
    private const val kNumPWMHeaders = 10
    private const val kNumDigitalChannels = 26
    private const val kNumPWMChannels = 20
    private const val kNumDigitalPWMOutputs = 6
    private const val kNumEncoders = 8
    private const val kNumInterrupts = 8
    private const val kNumRelayChannels = 8
    private const val kNumRelayHeaders = kNumRelayChannels / 2
    private const val kNumPCMModules = 63
    private const val kNumSolenoidChannels = 8
    private const val kNumPDPModules = 63
    private const val kNumPDPChannels = 16
    private const val kNumCanTalons = 63
    
    @JvmStatic fun getNumAccumulators(): Int {
        return kNumAccumulators
    }

    @JvmStatic fun getNumAnalogTriggers(): Int {
        return kNumAnalogTriggers
    }

    @JvmStatic fun getNumAnalogInputs(): Int {
        return kNumAnalogInputs
    }

    @JvmStatic fun getNumAnalogOutputs(): Int {
        return kNumAnalogOutputs
    }

    @JvmStatic fun getNumCounters(): Int {
        return kNumCounters
    }

    @JvmStatic fun getNumDigitalHeaders(): Int {
        return kNumDigitalHeaders
    }

    @JvmStatic fun getNumPWMHeaders(): Int {
        return kNumPWMHeaders
    }

    @JvmStatic fun getNumDigitalChannels(): Int {
        return kNumDigitalChannels
    }

    @JvmStatic fun getNumPWMChannels(): Int {
        return kNumPWMChannels
    }

    @JvmStatic fun getNumDigitalPWMOutputs(): Int {
        return kNumDigitalPWMOutputs
    }

    @JvmStatic fun getNumEncoders(): Int {
        return kNumEncoders
    }

    @JvmStatic fun getNumInterrupts(): Int {
        return kNumInterrupts
    }

    @JvmStatic fun getNumRelayChannels(): Int {
        return kNumRelayChannels
    }

    @JvmStatic fun getNumRelayHeaders(): Int {
        return kNumRelayHeaders
    }

    @JvmStatic fun getNumPCMModules(): Int {
        return kNumPCMModules
    }

    @JvmStatic fun getNumSolenoidChannels(): Int {
        return kNumSolenoidChannels
    }

    @JvmStatic fun getNumPDPModules(): Int {
        return kNumPDPModules
    }

    @JvmStatic fun getNumPDPChannels(): Int {
        return kNumPDPChannels
    }
}