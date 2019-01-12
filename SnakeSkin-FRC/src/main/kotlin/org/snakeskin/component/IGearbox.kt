package org.snakeskin.component

import org.snakeskin.ability.AInvertable

/**
 * @author Cameron Earle
 * @version 1/9/2019
 *
 */
interface IGearbox: AInvertable {
    /**
     * Sets the gearbox's "percent output" to the specified value
     */
    fun set(setpoint: Double)

    /**
     * Gets the "percent output" value applied to the motor
     */
    fun get(): Double

    /**
     * Stops the gearbox
     */
    fun stop()
}