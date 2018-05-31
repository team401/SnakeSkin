package org.snakeskin.logic

/*
 * snakeskin - Created on 5/30/18
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * Manages the state of a piston.  Provides "enums" for extended and retracted
 * @param solenoidOnForExtended Does the piston become extended when the solenoid is turned on
 * @author Cameron Earle
 * @version 5/30/18
 */
open class PistonState(solenoidOnForExtended: Boolean): BooleanState() {
    val EXTENDED = if (solenoidOnForExtended) ON else OFF
    val RETRACTED = if (solenoidOnForExtended) OFF else ON
}