package org.snakeskin.hardware

import org.snakeskin.hardware.impl.SoftwareTimeSource
import java.nio.ByteBuffer
import java.nio.IntBuffer
import java.util.*
import java.util.concurrent.ConcurrentHashMap

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

    private val hardwareRepo = ConcurrentHashMap<String, IHardware>()

    /**
     * Gets a hardware object from the hardware repository with the given type and id specified in 'key'
     *
     * @throws NoSuchElementException If the hardware with the given key could not be found
     */
    fun getHardware(key: String) = hardwareRepo.getOrElse(key) {
        throw NoSuchElementException("Could not find hardware '$key'")
    }

    /**
     * Adds a hardware object to the hardware repository
     */
    fun addHardware(key: String, hardware: IHardware) {
        hardwareRepo[key] = hardware
    }

    /**
     * Returns a read-only copy of the hardware repository.
     * This is a view of the hardware repository, meaning it stays up to date
     * with the hardware repository, but cannot be modified.
     */
    fun getRepository(): Map<String, IHardware> {
        return Collections.unmodifiableMap(hardwareRepo)
    }
}