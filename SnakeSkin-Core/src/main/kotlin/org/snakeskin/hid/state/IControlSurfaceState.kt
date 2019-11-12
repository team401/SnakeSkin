package org.snakeskin.hid.state

import org.snakeskin.executor.ExceptionHandlingRunnable

/**
 * @author Cameron Earle
 * @version 12/12/2018
 *
 */
interface IControlSurfaceState {
    fun update(timestamp: Double): Boolean
    val action: ExceptionHandlingRunnable
}