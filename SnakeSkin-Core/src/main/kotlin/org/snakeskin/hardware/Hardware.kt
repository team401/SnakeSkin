package org.snakeskin.hardware

import org.snakeskin.hardware.impl.SoftwareTimeSource

/**
 * @author Cameron Earle
 * @version 7/30/2018
 *
 * Base object to obtain instances of hardware objects.  Designed to be extended through extension functions
 * by other modules.
 */
object Hardware {
    /**
     * The environment to initialize hardware in
     */
    var environment: Environment = Environment.HARDWARE
        @Synchronized get
        @Synchronized set

    private lateinit var timeSource: TimeSource

    /**
     * Sets the time source.  This should be called automatically on startup
     */
    fun setTimeSource(timeSource: TimeSource) {
        this.timeSource = timeSource
    }

    fun getRelativeTime(): Double = timeSource.getRelativeTime()
    fun getAbsoluteTime(): Long = timeSource.getAbsoluteTime()
}