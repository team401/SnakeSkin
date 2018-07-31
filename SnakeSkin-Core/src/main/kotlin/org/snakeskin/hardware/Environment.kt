package org.snakeskin.hardware

/**
 * @author Cameron Earle
 * @version 7/30/2018
 *
 * Represents the possible environments that a user application can be run in.
 *
 * HARDWARE represents the system running on the embedded hardware, such as a RoboRIO
 * SOFTWARE represents the system running on a development system, such as an x86 laptop
 *
 * These environments can be used to determine how to initialize hardware (eg. whether or not to use
 * real hardware objects or emulated hardware objects)
 */
enum class Environment {
    HARDWARE,
    SOFTWARE
}