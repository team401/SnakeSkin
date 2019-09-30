package org.snakeskin.runtime

/**
 * Represents the required functionality that must be implemented by a hardware platform
 * Provides platform specific runtime calls
 */
interface IRuntimePlatformBinding {
    /**
     * Implementations need to return the "platform time" in seconds.
     * This time should ideally be provided by a fast clock.  For example,
     * on the roboRIO, this would be the FPGA clock
     */
    fun getTimestampSeconds(): Double
}