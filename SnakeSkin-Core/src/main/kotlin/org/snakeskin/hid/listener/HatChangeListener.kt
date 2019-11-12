package org.snakeskin.hid.listener

import org.snakeskin.hid.HIDHat

/**
 * @author Cameron Earle
 * @version 12/12/2018
 *
 */
class HatChangeListener(val surface: HIDHat, val action: (Int) -> Unit): IControlSurfaceListener