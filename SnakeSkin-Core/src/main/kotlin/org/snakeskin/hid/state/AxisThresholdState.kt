package org.snakeskin.hid.state

import org.snakeskin.hid.listener.AxisThresholdListener
import org.snakeskin.executor.ExceptionHandlingRunnable
import org.snakeskin.hid.HIDAxis
import org.snakeskin.hid.provider.IAxisValueProvider

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

    private var crossEventFired = false
    private var currentValue = 0.0

    override fun update(timestamp: Double): Boolean {
        currentValue = listener.surface.read()
        if (isPassedThreshold(currentValue)) {
            //We only want to fire the event once per crossing of the threshold, so this ensures that
            if (!crossEventFired) {
                crossEventFired = true
                return listener.direction == AxisThresholdListener.CrossDirection.Outward //Fire if we are looking for out
            }
        } else {
            if (crossEventFired) {
                crossEventFired = false
                return listener.direction == AxisThresholdListener.CrossDirection.Inward //Fire if we are looking for in
            }
        }
        return false
    }

    override val action = ExceptionHandlingRunnable {
        listener.action(currentValue)
    }
}