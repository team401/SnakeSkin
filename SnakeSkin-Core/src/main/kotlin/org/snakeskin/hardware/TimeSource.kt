package org.snakeskin.hardware

/**
 * @author Cameron Earle
 * @version 7/30/2018
 *
 */
interface TimeSource {
    /**
     * Implementations must return the startup-relative system time in seconds
     */
    fun getRelativeTime(): Double

    /**
     * Implementations must return the absolute system time in milliseconds
     *
     * Default implementation returns System.currentTimeMillis()
     */
    fun getAbsoluteTime(): Long = System.currentTimeMillis()
}