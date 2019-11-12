package org.snakeskin.hid.listener

import org.snakeskin.hid.HIDButton

/**
 * @author Cameron Earle
 * @version 12/12/2018
 *
 */
class ButtonEdgeListener(val surface: HIDButton, val edgeType: EdgeType, val action: (Boolean) -> Unit): IControlSurfaceListener {
    enum class EdgeType {
        Pressed,
        Released
    }
}