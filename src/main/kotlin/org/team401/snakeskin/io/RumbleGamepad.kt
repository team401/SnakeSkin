package org.team401.snakeskin.io

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
interface RumbleGamepad : Gamepad {

    fun setRumble(intensity: Double)

    fun setLeftRumble(intensity: Double)

    fun setRightRumble(intensity: Double)

    fun stopRumble()
}