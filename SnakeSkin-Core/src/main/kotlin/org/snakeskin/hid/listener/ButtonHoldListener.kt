package org.snakeskin.hid.listener

import org.snakeskin.hid.HIDButton
import org.snakeskin.measure.time.TimeMeasureSeconds

/**
 * @author Cameron Earle
 * @version 12/12/2018
 *
 */
class ButtonHoldListener(val surface: HIDButton, holdDuration: TimeMeasureSeconds, val action: (Boolean) -> Unit): IControlSurfaceListener {
    val holdDurationS = holdDuration.value
}