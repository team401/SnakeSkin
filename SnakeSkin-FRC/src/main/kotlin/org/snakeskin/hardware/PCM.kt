package org.snakeskin.hardware

import org.snakeskin.logic.LockingDelegate

/**
 * @author Cameron Earle
 * @version 9/30/18
 *
 * Represents a Pneumatic Control Module.
 */
class PCM: IHardware {
    companion object {
        fun getFromHardwareRepository(id: Int): PCM {
            return Hardware.getHardware("pcm/$id") as PCM
        }
    }

    class Port {
        var on by LockingDelegate(false)
        var blacklisted by LockingDelegate(false)
        var pulseDuration by LockingDelegate(0L)
    }

    /**
     * Internal storage for ports
     */
    private val ports = arrayOf(
            Port(),
            Port(),
            Port(),
            Port(),
            Port(),
            Port(),
            Port(),
            Port()
    )

    var voltageFault by LockingDelegate(false)

    var voltageStickyFault by LockingDelegate(false)

    /**
     * Gets the value of the port with the specified id
     */
    @Synchronized fun getPort(id: Int): Port {
        return ports[id]
    }
}