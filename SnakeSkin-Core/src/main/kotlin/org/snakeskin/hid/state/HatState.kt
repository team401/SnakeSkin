package org.snakeskin.hid.state

import org.snakeskin.hid.listener.HatChangeListener
import org.snakeskin.executor.ExceptionHandlingRunnable
import org.snakeskin.utility.value.HistoryInt

/**
 * @author Cameron Earle
 * @version 12/12/2018
 *
 */
class HatState(val listener: HatChangeListener): IControlSurfaceState {
    private val history = HistoryInt()

    override fun update(timestamp: Double): Boolean {
        history.update(listener.surface.read())
        if (history.current != Int.MIN_VALUE && history.last != Int.MIN_VALUE) {
            if (history.changed()) {
                return true
            }
        }
        return false
    }

    override val action = ExceptionHandlingRunnable {
        listener.action(history.current)
    }
}