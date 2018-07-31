package org.snakeskin.hardware.impl

import org.snakeskin.factory.ExecutorFactory
import org.snakeskin.hardware.Solenoid
import org.snakeskin.logic.LockingDelegate
import org.snakeskin.units.TimeUnit
import org.snakeskin.units.measure.time.TimeMeasure


/**
 * @author Cameron Earle
 * @version 7/30/2018
 *
 */
class SoftwareSolenoid: Solenoid {
    var value by LockingDelegate(false)
    var pulseDuration by LockingDelegate(0.0)

    var blackListed by LockingDelegate(false)

    private val executor by lazy {
        ExecutorFactory.getExecutor("Software Solenoid Pulse")
    }

    override fun get(): Boolean {
        return value
    }

    override fun set(value: Boolean) {
        this.value = value
    }

    override fun isBlackListed(): Boolean {
        return blackListed
    }

    override fun setPulseDuration(duration: TimeMeasure) {
        pulseDuration = duration.toUnit(TimeUnit.Standard.SECONDS).value
    }

    override fun startPulse() {
        value = true
        executor.schedule({value = false}, (pulseDuration * 1000L).toLong(), java.util.concurrent.TimeUnit.MILLISECONDS)
    }
}