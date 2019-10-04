package org.snakeskin.controls.state

import org.snakeskin.controls.listener.AxisThresholdListener
import org.snakeskin.executor.ExceptionHandlingRunnable

/**
 * @author Cameron Earle
 * @version 12/12/2018
 *
 */
class AxisThresholdState(override val listener: AxisThresholdListener): ControlSurfaceState<Double> {
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