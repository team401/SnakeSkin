package org.snakeskin.component.impl

import edu.wpi.first.wpilibj.Solenoid
import org.snakeskin.component.IPneumaticChannel

class HardwarePneumaticChannel(val channel: Solenoid): IPneumaticChannel {
    override fun setState(state: Boolean) {
        channel.set(state)
    }
}