package org.snakeskin.hardware.impl

import edu.wpi.first.wpilibj.Timer
import org.snakeskin.hardware.TimeSource

/**
 * @author Cameron Earle
 * @version 8/12/18
 */
class HardwareTimeSource: TimeSource {
    override fun getRelativeTime(): Double {
        return Timer.getFPGATimestamp()
    }
}