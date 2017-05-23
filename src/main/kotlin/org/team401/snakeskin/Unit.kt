package org.team401.snakeskin

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
 * Default unit (multiplier of 1.0) is Inches
 */
enum class Unit(val multiplier: Double) {
    INCHES(1.0),
    FEET(1.0 / 12),
    CENTIMETERS(1.0 * 2.54),
    METERS(1.0 * 2.54 / 100)
}