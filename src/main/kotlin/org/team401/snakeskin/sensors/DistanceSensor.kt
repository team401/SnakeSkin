package org.team401.snakeskin.sensors

/*
 * SnakeSkin - Created on 5/22/17
 * Author: Zachary Kozar
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at the project root.
 */

/**
 * @author Zachary Kozar
 * @version 5/22/17
 *
 * A sensor that can detect a distance and return the value as a double
 */
interface DistanceSensor {

    fun getDistance(): Double
}