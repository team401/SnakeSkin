package org.snakeskin.controls.state

import org.snakeskin.controls.listener.AxisThresholdListener

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

    override fun update(timestamp: Double): Runnable? {
        val currentValue = listener.surface.read()
        if (isPassedThreshold(currentValue)) {
            //We only want to fire the event once per crossing of the threshold, so this ensures that
            if (!eventFired) {
                eventFired = true
                return Runnable {
                    listener.action(currentValue)
                }
            }
        } else {
            eventFired = false
        }
        return null
    }
}