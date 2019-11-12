package org.snakeskin.hid.state

import org.snakeskin.hid.listener.AxisThresholdListener
import org.snakeskin.executor.ExceptionHandlingRunnable

/**
 * @author Cameron Earle
 * @version 12/12/2018
 *
 */
class AxisThresholdState(val listener: AxisThresholdListener): IControlSurfaceState {
    private fun isPassedThreshold(value: Double): Boolean {
        //We have to take sign into account here
        return if (listener.threshold > 0.0) { //Positive threshold
            value > listener.threshold
        } else { //Negative threshold
            value < listener.threshold
        }
    }

    private var eventFired = false
    private var currentValue = 0.0

    override fun update(timestamp: Double): Boolean {
        currentValue = listener.surface.read()
        if (isPassedThreshold(currentValue)) {
            //We only want to fire the event once per crossing of the threshold, so this ensures that
            if (!eventFired) {
                eventFired = true
                return true
            }
        } else {
            eventFired = false
        }
        return false
    }

    override val action = ExceptionHandlingRunnable {
        listener.action(currentValue)
    }
}