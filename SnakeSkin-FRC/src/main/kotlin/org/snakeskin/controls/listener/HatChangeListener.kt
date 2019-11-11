package org.snakeskin.controls.listener

import org.snakeskin.controls.Hat

/**
 * @author Cameron Earle
 * @version 12/12/2018
 *
 */
class HatChangeListener(val surface: Hat, val action: (Int) -> Unit): IControlSurfaceListener