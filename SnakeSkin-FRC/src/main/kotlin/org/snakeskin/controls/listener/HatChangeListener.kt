package org.snakeskin.controls.listener

import org.snakeskin.controls.Hat

/**
 * @author Cameron Earle
 * @version 12/12/2018
 *
 */
class HatChangeListener(override val surface: Hat, override val action: (Int) -> Unit): ControlListener<Hat, Int>