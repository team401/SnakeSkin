package org.snakeskin.controls.listener

import org.snakeskin.controls.Button

/**
 * @author Cameron Earle
 * @version 12/12/2018
 *
 */
class ButtonEdgeListener(val surface: Button, val edgeType: EdgeType, val action: (Boolean) -> Unit): IControlSurfaceListener {
    enum class EdgeType {
        PRESSED,
        RELEASED
    }
}