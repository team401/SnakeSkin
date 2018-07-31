package org.snakeskin.hardware

import org.snakeskin.hardware.impl.SoftwareTimeSource
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

    private val hardwareRepo = ConcurrentHashMap<HardwareKey, IHardware>()

    /**
     * Gets a hardware object from the hardware repository with the given type and id specified in 'key'
     *
     * @throws NoSuchElementException If the hardware with the given key could not be found
     */
    fun getHardware(key: HardwareKey) = hardwareRepo.getOrElse(key) {
        throw NoSuchElementException("Could not find hardware of type '${key.type}' with id '${key.id}'")
    }

    /**
     * Adds a hardware object to the hardware repository
     */
    fun addHardware(key: HardwareKey, hardware: IHardware) {
        hardwareRepo[key] = hardware
    }

    /**
     * Returns a read-only copy of the hardware repository.
     * This is a view of the hardware repository, meaning it stays up to date
     * with the hardware repository, but cannot be modified.
     */
    fun getRepository(): Map<HardwareKey, IHardware> {
        return Collections.unmodifiableMap(hardwareRepo)
    }
}