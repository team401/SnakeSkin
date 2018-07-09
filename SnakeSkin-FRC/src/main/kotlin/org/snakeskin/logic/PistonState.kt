package org.snakeskin.logic

/**
 * @author Cameron Earle
 * @version 5/30/18
 *
 * Manages the state of a piston.  Provides "enums" for extended and retracted
 * @param solenoidOnForExtended Does the piston become extended when the solenoid is turned on
 */
open class PistonState(solenoidOnForExtended: Boolean): BooleanState() {
    val EXTENDED = if (solenoidOnForExtended) ON else OFF
    val RETRACTED = if (solenoidOnForExtended) OFF else ON
}