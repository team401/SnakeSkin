package org.snakeskin.controls.state

import org.snakeskin.controls.listener.ControlListener

/**
 * @author Cameron Earle
 * @version 12/12/2018
 *
 */
interface ControlSurfaceState<T> {
    val listener: ControlListener<*, T>
    fun update(timestamp: Double): Runnable?
}