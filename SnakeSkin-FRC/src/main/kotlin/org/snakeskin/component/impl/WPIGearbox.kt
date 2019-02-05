package org.snakeskin.component.impl

import edu.wpi.first.wpilibj.SpeedController
import org.snakeskin.component.IGearbox

/**
 * @author Cameron Earle
 * @version 1/9/2019
 *
 */
open class WPIGearbox(private vararg val motorControllers: SpeedController): IGearbox {
    override var inverted = false

    override fun set(setpoint: Double) {
        motorControllers.forEach {
            it.set(setpoint)
        }
    }

    override fun get(): Double {
        return motorControllers.first().get()
    }

    override fun stop() {
        set(0.0)
    }
}