package org.snakeskin.hid.listener

import org.snakeskin.hid.HIDAxis

/**
 * @author Cameron Earle
 * @version 12/12/2018
 *
 */
class AxisThresholdListener(val surface: HIDAxis, val threshold: Double, val direction: CrossDirection, val action: (Double) -> Unit): IControlSurfaceListener {
    enum class CrossDirection {
        /**
         * Event fired when axis crosses the threshold towards the extremes of the axis (irrelevant of direction)
         */
        Outward,

        /**
         * Event fired when axis crosses the threshold towards the center of the axis (irrelevant of direction)
         */
        Inward
    }
}