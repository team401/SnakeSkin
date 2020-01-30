package org.snakeskin.component.impl

import edu.wpi.first.wpilibj.DigitalInput
import org.snakeskin.component.IDigitalInputChannel

class HardwareDigitalInputChannel(val channel: DigitalInput) : IDigitalInputChannel {
    override fun getState(): Boolean {
        return channel.get()
    }
}