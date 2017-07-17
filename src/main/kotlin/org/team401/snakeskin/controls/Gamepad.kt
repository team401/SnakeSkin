package org.team401.snakeskin.controls

import org.team401.snakeskin.controls2.Axis
import org.team401.snakeskin.logic.DirectionalAxis
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

    fun getLeftX(): Axis
    fun getLeftY(): Axis
    fun getRightX(): Axis
    fun getRightY(): Axis
    fun getLeftTrigger(): Axis
    fun getRightTrigger(): Axis

    fun getA(): Switch
    fun getB(): Switch
    fun getX(): Switch
    fun getY(): Switch

    fun getLeftBumper(): Switch
    fun getRightBumper(): Switch
    
    fun getLeftStick(): Switch
    fun getRightStick(): Switch

    fun getStart(): Switch
    fun getSelect(): Switch

    fun getDPad(): DirectionalAxis
}