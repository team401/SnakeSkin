package org.team401.snakeskin.io

import edu.wpi.first.wpilibj.Joystick

/*
 * SnakeSkin - Created on 5/24/2017
 * Author: Zachary Kozar
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at the project root.
 */

/**
 * @author Zachary Kozar
 * @version 5/24/2017
 */
open class OutputDevice(dsPort: Int) {

    internal val output = Joystick(dsPort)

    fun setOutput(port: Int, value: Boolean) = output.setOutput(port, value)
}