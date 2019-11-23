package org.snakeskin.hid.listener

import org.snakeskin.hid.HIDButton

/**
 * @author Cameron Earle
 * @version 12/12/2018
 *
 */
class ButtonEdgeListener(val surface: HIDButton, val edgeType: EdgeType, val action: (Boolean) -> Unit): IControlSurfaceListener {
    enum class EdgeType {
        /**
         * Event fired when the button gets a "rising edge", meaning it is pressed
         */
        Pressed,

        /**
         * Event fired when the button gets a "falling edge", meaning it is released
         */
        Released
    }
}