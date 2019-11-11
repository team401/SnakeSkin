package org.snakeskin.controls.listener

import org.snakeskin.controls.Axis

/**
 * @author Cameron Earle
 * @version 12/12/2018
 *
 */
class AxisThresholdListener(val surface: Axis, val threshold: Double, val action: (Double) -> Unit): IControlSurfaceListener