package org.snakeskin.controls.listener

import org.snakeskin.controls.Axis

/**
 * @author Cameron Earle
 * @version 12/12/2018
 *
 */
class AxisThresholdListener(override val surface: Axis, val threshold: Double, override val action: (Double) -> Unit): ControlListener<Axis, Double>