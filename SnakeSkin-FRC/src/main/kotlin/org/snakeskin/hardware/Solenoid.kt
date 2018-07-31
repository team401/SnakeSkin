package org.snakeskin.hardware

import edu.wpi.first.wpilibj.Solenoid
import org.snakeskin.units.measure.time.TimeMeasure

/**
 * @author Cameron Earle
 * @version 7/30/2018
 *
 */
interface Solenoid: IHardware<Solenoid> {
    fun get(): Boolean
    fun set(value: Boolean)

    val isBlackListed: Boolean

    fun setPulseDuration(duration: TimeMeasure)
    fun startPulse()
}