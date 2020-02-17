package org.snakeskin.component.impl

import edu.wpi.first.wpilibj.DigitalOutput
import org.snakeskin.component.IDigitalOutputChannel

class HardwareDigitalOutputChannel(val channel: DigitalOutput): IDigitalOutputChannel {
    override fun setState(state: Boolean) {
        channel.set(state)
    }
}