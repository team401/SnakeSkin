package org.team401.snakeskin.controls

import org.team401.snakeskin.controls2.Axis
import org.team401.snakeskin.logic.Switch

/*
 * SnakeSkin - Created on 5/24/17
 * Author: Zachary Kozar
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at the project root.
 */

/**
 * @author Zachary Kozar
 * @version 5/24/17
 */
interface Joystick {

    fun getYaw(): Axis
    fun getPitch(): Axis
    fun getRoll(): Axis

    fun getThrottle(): Axis

    fun getTrigger(): Switch
    fun getThumb(): Switch
}