package org.team401.snakeskin.sensors

import org.team401.snakeskin.logic.Switch

/*
 * SnakeSkin - Created on 5/23/2017
 * Author: Zachary Kozar
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at the project root.
 */

/**
 * @author Zachary Kozar
 * @version 5/23/2017
 *
 * A sensor that can detect if an object is in front of it
 */
interface PresenceSensor : Switch {

    override fun isTriggered(): Boolean
}