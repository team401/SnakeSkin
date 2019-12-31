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
     * A platform that represents a general PC, running the application at real time (or as close as possible to it).
     */
    PC("org.snakeskin.runtime.impl.RuntimePlatformBindingPc"),

    /**
     * An NI roboRIO, running in the context of FRC (with FRC libraries)
     */
    FRC_ROBORIO("org.snakeskin.runtime.impl.RuntimePlatformBindingFrcRoborio")
}