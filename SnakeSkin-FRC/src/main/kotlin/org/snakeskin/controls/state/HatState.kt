package org.snakeskin.controls.state

import org.snakeskin.controls.listener.HatChangeListener
import org.snakeskin.executor.ExceptionHandlingRunnable
import org.snakeskin.logic.History

/**
 * @author Cameron Earle
 * @version 12/12/2018
 *
 */
class HatState(override val listener: HatChangeListener): ControlSurfaceState<Int> {
    private val history = History<Int>()

    override fun update(timestamp: Double): Boolean {
        history.update(listener.surface.read())
        if (history.current != null && history.last != null) {
            if (history.current != history.last) {
                return true
            }
        }
        return false
    }

    override val action = ExceptionHandlingRunnable {
        listener.action(history.current!!)
    }
}