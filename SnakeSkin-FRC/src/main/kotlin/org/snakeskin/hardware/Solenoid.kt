package org.snakeskin.hardware

import org.snakeskin.units.measure.time.TimeMeasure

/**
 * @author Cameron Earle
 * @version 7/30/2018
 *
 */
interface Solenoid: IHardware {
    fun get(): Boolean
    fun set(value: Boolean)

    fun isBlackListed(): Boolean

    fun setPulseDuration(duration: TimeMeasure)
    fun startPulse()
}