package org.snakeskin.controls.listener

import org.snakeskin.controls.Button
import org.snakeskin.units.TimeUnit
import org.snakeskin.units.measure.time.TimeMeasure

/**
 * @author Cameron Earle
 * @version 12/12/2018
 *
 */
class ButtonHoldListener(override val surface: Button, holdDuration: TimeMeasure, override val action: (Boolean) -> Unit): ControlListener<Button, Boolean> {
    val holdDurationS = holdDuration.toUnit(TimeUnit.Standard.SECONDS).value
}