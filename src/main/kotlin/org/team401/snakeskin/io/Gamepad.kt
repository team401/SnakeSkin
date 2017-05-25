package org.team401.snakeskin.io

import org.team401.snakeskin.logic.DirectionalAxis
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
interface Gamepad {

    fun getX(): Switch
    fun getY(): Switch
    fun getA(): Switch
    fun getB(): Switch

    fun getLeftTrigger(): Range
    fun getRightTrigger(): Range

    fun getLeftBumper(): Switch
    fun getRightBumper(): Switch

    fun getLeftX(): Range
    fun getLeftY(): Range
    fun getLeftStick(): Switch

    fun getRightX(): Range
    fun getRightY(): Range
    fun getRightStick(): Switch

    fun getStart(): Switch
    fun getSelect(): Switch

    fun getDPad(): DirectionalAxis
}