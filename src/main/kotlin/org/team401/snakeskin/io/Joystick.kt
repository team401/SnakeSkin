package org.team401.snakeskin.io

import org.team401.snakeskin.logic.Range
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

    fun getYaw(): Range
    fun getPitch(): Range
    fun getRoll(): Range

    fun getThrottle(): Range

    fun getTrigger(): Switch
    fun getThumb(): Switch
}