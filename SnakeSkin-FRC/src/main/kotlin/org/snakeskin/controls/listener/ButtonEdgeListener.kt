package org.snakeskin.controls.listener

import org.snakeskin.controls.Button

/**
 * @author Cameron Earle
 * @version 12/12/2018
 *
 */
class ButtonEdgeListener(override val surface: Button, val edgeType: EdgeType, override val action: (Boolean) -> Unit): ControlListener<Button, Boolean> {
    enum class EdgeType {
        PRESSED,
        RELEASED
    }
}