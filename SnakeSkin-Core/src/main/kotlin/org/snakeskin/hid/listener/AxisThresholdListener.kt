package org.snakeskin.hid.listener

import org.snakeskin.hid.HIDAxis

/**
 * @author Cameron Earle
 * @version 12/12/2018
 *
 */
class AxisThresholdListener(val surface: HIDAxis, val threshold: Double, val action: (Double) -> Unit): IControlSurfaceListener