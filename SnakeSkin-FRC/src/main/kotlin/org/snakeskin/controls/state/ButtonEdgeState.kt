package org.snakeskin.controls.state

import org.snakeskin.controls.listener.ButtonEdgeListener
import org.snakeskin.executor.ExceptionHandlingRunnable
import org.snakeskin.utility.value.HistoryBoolean

/**
 * @author Cameron Earle
 * @version 12/12/2018
 *
 * Tracks the state of a button's edge
 */
class ButtonEdgeState(val listener: ButtonEdgeListener): IControlSurfaceState {
    private val history = HistoryBoolean()

    private val edgeValue = when (listener.edgeType) {
        ButtonEdgeListener.EdgeType.PRESSED -> true
        ButtonEdgeListener.EdgeType.RELEASED -> false
    }

    override fun update(timestamp: Double): Boolean {
        history.update(listener.surface.read())

        if (history.current == edgeValue) {
            if (history.last == !edgeValue) {
                return true
            }
        }
        return false
    }

    override val action = ExceptionHandlingRunnable {
        listener.action(edgeValue)
    }
}