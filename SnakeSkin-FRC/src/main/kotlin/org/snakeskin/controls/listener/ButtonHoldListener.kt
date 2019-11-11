package org.snakeskin.controls.listener

import org.snakeskin.controls.Button
import org.snakeskin.measure.time.TimeMeasureSeconds

/**
 * @author Cameron Earle
 * @version 12/12/2018
 *
 */
class ButtonHoldListener(val surface: Button, holdDuration: TimeMeasureSeconds, val action: (Boolean) -> Unit): IControlSurfaceListener {
    val holdDurationS = holdDuration.value
}