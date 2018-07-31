package org.snakeskin.hardware.impl

import edu.wpi.first.wpilibj.Timer
import org.snakeskin.hardware.TimeSource

/**
 * @author Cameron Earle
 * @version 7/30/2018
 *
 */
class HardwareTimeSource: TimeSource {
    override fun getRelativeTime(): Double {
        return Timer.getFPGATimestamp()
    }
}