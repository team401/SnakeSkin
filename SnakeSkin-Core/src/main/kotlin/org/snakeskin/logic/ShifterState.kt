package org.snakeskin.logic

/*
 * snakeskin - Created on 5/30/18
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * Manages the states of a typical shifter piston
 * @param solenoidOnForExtended Does the piston extend when the solenoid is on
 * @param extendedForLowGear Is the shifter in low gear when the piston is extended
 * @author Cameron Earle
 * @version 5/30/18
 */
class ShifterState(solenoidOnForExtended: Boolean, extendedForLowGear: Boolean): PistonState(solenoidOnForExtended) {
    val LOW = if (extendedForLowGear) EXTENDED else RETRACTED
    val HIGH = if (extendedForLowGear) RETRACTED else EXTENDED
}