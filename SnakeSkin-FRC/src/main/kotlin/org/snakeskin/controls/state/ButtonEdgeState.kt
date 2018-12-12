package org.snakeskin.controls.state

import org.snakeskin.controls.listener.ButtonEdgeListener
import org.snakeskin.logic.History

/**
 * @author Cameron Earle
 * @version 12/12/2018
 *
 * Tracks the state of a button's edge
 */
class ButtonEdgeState(override val listener: ButtonEdgeListener): ControlSurfaceState<Boolean> {
    private val history = History<Boolean>()

    private val edgeValue = when (listener.edgeType) {
        ButtonEdgeListener.EdgeType.PRESSED -> true
        ButtonEdgeListener.EdgeType.RELEASED -> false
    }

    override fun update(timestamp: Double): Runnable? {
        history.update(listener.surface.read())

        if (history.current == edgeValue) {
            if (history.last == !edgeValue) {
                return Runnable {
                    listener.action(edgeValue)
                }
            }
        }
        return null
    }
}