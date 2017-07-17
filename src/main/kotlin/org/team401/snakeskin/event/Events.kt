package org.team401.snakeskin.event

/*
 * snakeskin - Created on 7/16/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 7/16/17
 */

object Events {
    //This is a collection of built in events that are fired internally by the lib
    const val DISABLED = "snakeskin.event.robotState.disabled"
    const val AUTO_ENABLED = "snakeskin.event.robotState.autoEnabled"
    const val TELEOP_ENABLED = "snakeskin.event.robotState.teleopEnabled"

}