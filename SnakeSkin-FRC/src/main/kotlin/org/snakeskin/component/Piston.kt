package org.snakeskin.component

import edu.wpi.first.wpilibj.Solenoid
import org.snakeskin.ability.AInvertable
import org.snakeskin.ability.AToggleable
import org.snakeskin.ability.AWaitable
import org.snakeskin.logic.TimedWaitable

/**
 * @author Cameron Earle
 * @version 8/17/17
 */

class Piston(val port: Int, val pcm: Int = 0, val extensionTime: Long = 0, val retractionTime: Long = 0): AInvertable, AToggleable {
    override var inverted: Boolean = false

    private val solenoid = Solenoid(pcm, port)

    fun extend(): AWaitable {
        if (inverted) {
            solenoid.set(false)
        } else {
            solenoid.set(true)
        }
        return TimedWaitable(extensionTime).start()
    }

    fun retract(): AWaitable {
        if (inverted) {
            solenoid.set(true)
        } else {
            solenoid.set(false)
        }
        return TimedWaitable(retractionTime).start()
    }

    override fun toggle() {
        solenoid.set(!solenoid.get())
    }


}