package org.snakeskin.controls.listener

import org.snakeskin.controls.Button
import org.snakeskin.measure.time.TimeMeasureSeconds

/**
 * @author Cameron Earle
 * @version 12/12/2018
 *
 */
class ButtonHoldListener(override val surface: Button, holdDuration: TimeMeasureSeconds, override val action: (Boolean) -> Unit): ControlListener<Button, Boolean> {
    val holdDurationS = holdDuration.value
}