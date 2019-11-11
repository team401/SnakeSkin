package org.snakeskin.controls.state

import org.snakeskin.controls.listener.ButtonHoldListener
import org.snakeskin.executor.ExceptionHandlingRunnable

/**
 * @author Cameron Earle
 * @version 12/12/2018
 *
 */
class ButtonTimedState(val listener: ButtonHoldListener): IControlSurfaceState {
    private var risingEdgeTimestamp = 0.0

    private var eventFired = false

    override fun update(timestamp: Double): Boolean {
        if (listener.surface.read()) { //Button is held
            if (risingEdgeTimestamp == 0.0) risingEdgeTimestamp = timestamp //Register timestamp if it's not already set
            if (timestamp - risingEdgeTimestamp >= listener.holdDurationS) { //Measure dt, if it's greater than the duration we have an event
                //We only want to fire the event once per hold, so this ensures that
                if (!eventFired) { //If we haven't fired the event
                    eventFired = true //Now we have
                    return true
                }
            }
        } else { //Button is released, reset everything
            risingEdgeTimestamp = 0.0
            eventFired = false
        }
        return false
    }

    override val action = ExceptionHandlingRunnable {
        listener.action(true)
    }
}