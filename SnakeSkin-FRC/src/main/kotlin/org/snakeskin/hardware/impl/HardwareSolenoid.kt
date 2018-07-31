package org.snakeskin.hardware.impl

import org.snakeskin.hardware.Solenoid
import org.snakeskin.units.TimeUnit
import org.snakeskin.units.measure.time.TimeMeasure

/**
 * @author Cameron Earle
 * @version 7/30/2018
 *
 */
class HardwareSolenoid(id: Int, pcm: Int): Solenoid {
    val solenoid = edu.wpi.first.wpilibj.Solenoid(pcm, id)

    override fun get(): Boolean {
        return solenoid.get()
    }

    override fun set(value: Boolean) {
        solenoid.set(value)
    }

    override fun setPulseDuration(duration: TimeMeasure) {
        solenoid.setPulseDuration(duration.toUnit(TimeUnit.Standard.SECONDS).value)
    }

    override fun startPulse() {
        solenoid.startPulse()
    }

    override fun isBlackListed(): Boolean {
        return solenoid.isBlackListed
    }
}