package org.team401.snakeskin.component

/*
 * SnakeSkin - Created on 6/2/17
 * Author: Zachary Kozar
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at the project root.
 */

/**
 * @author Zachary Kozar
 * @version 6/2/17
 */
interface LinearActuator {

    fun set(input: Double)

    fun getPosition(): Double
}