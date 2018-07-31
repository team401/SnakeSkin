package org.snakeskin.hardware.impl

import org.snakeskin.hardware.TimeSource

/**
 * @author Cameron Earle
 * @version 7/30/2018
 *
 */
class SoftwareTimeSource: TimeSource {
    override fun getRelativeTime(): Double {
        return System.nanoTime() * 1e-9
    }
}