package org.snakeskin

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