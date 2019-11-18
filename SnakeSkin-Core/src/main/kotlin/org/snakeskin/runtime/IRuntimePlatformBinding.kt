package org.snakeskin.runtime

import org.snakeskin.executor.IExecutor
import org.snakeskin.hid.IHIDValueProviderFactory
import org.snakeskin.rt.IRealTimeExecutor

/**
 * Represents the required functionality that must be implemented by a hardware platform
 * Provides platform specific runtime calls
 */
interface IRuntimePlatformBinding {
    /**
     * Implementations should return the relative time in seconds.  This is not the wall clock time.
     * This time should ideally be provided by a fast clock.  For example,
     * on the roboRIO, this would be the FPGA clock
     */
    fun getTimestampSeconds(): Double

    /**
     * Implementations should block the active thread for the given number
     * of milliseconds as precisely as possible
     */
    fun blockMilliseconds(ms: Long)

    /**
     * Implementations should return the current system vbus voltage, in volts.
     */
    fun getSystemVbusVolts(): Double

    /**
     * Implementations should allocate, start, and return the primary runtime executor.
     */
    fun allocatePrimaryExecutor(): IExecutor

    /**
     * Implementations should allocate, start, and return an executor which is separate from all other executors
     */
    fun allocateSingleUseExecutor(): IExecutor

    /**
     * Implementations should to allocate and return a real time executor with the given rate
     */
    fun allocateRealTimeExecutor(rateSeconds: Double): IRealTimeExecutor

    /**
     * Implementations should allocate and return an HID value provider factory for the given controller ID
     */
    fun allocateHIDValueProviderFactory(id: Int): IHIDValueProviderFactory
}