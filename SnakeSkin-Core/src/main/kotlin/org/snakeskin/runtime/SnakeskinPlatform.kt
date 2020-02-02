package org.snakeskin.runtime

/**
 * Represents the various platforms SnakeSkin can run on.  These platforms represent actual hardware,
 * and not necessarily a specific operating system
 *
 * @param platformBindingClass The fully qualified class name of the binding class for this platform.
 */
enum class SnakeskinPlatform(val platformBindingClass: String) {
    /**
     * No platform set.  This WILL cause issues, and only exists to notify the user that there is no platform set
     */
    UNDEFINED(""),

    /**
     * A platform that represents a completely software oriented system.  This is useful for simulation.
     * In this platform, all timing and execution are mocked and steppable
     */
    SOFTWARE("org.snakeskin.runtime.impl.RuntimePlatformBindingSoftware"),

    /**
     * An NI roboRIO, running in the context of FRC (with FRC libraries)
     */
    FRC_ROBORIO("org.snakeskin.runtime.impl.RuntimePlatformBindingFrcRoborio"),

    /**
     * An FRC robot running in WPI HAL simulation mode.  All hardware objects that are not WPILib components
     * using mock producers.
     */
    FRC_WPISIM("org.snakeskin.runtime.impl.RuntimePlatformBindingFrcWpiSim")
}