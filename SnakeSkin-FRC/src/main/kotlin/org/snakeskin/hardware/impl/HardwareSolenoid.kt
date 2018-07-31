package org.snakeskin.hardware.impl

import org.snakeskin.hardware.Solenoid
import org.snakeskin.units.TimeUnit
import org.snakeskin.units.measure.time.TimeMeasure

/**
 * @author Cameron Earle
 * @version 7/30/2018
 *
 */
class HardwareSolenoid(override val hardwareObj: edu.wpi.first.wpilibj.Solenoid): Solenoid {
    override fun get(): Boolean {
        return hardwareObj.get()
    }

    override fun set(value: Boolean) {
        hardwareObj.set(value)
    }

    override fun setPulseDuration(duration: TimeMeasure) {
        hardwareObj.setPulseDuration(duration.toUnit(TimeUnit.Standard.SECONDS).value)
    }

    override fun startPulse() {
        hardwareObj.startPulse()
    }

    override val isBlackListed: Boolean
        get() = hardwareObj.isBlackListed
}