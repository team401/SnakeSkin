package org.team401.snakeskin.sensors

import edu.wpi.first.wpilibj.DigitalInput

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
 * A sensor that can detect whether an object is in front of it or not
 */
class BannerSensor(dioPort: Int) : PresenceSensor {

    private val input = DigitalInput(dioPort)

    override fun isTriggered(): Boolean {
        return input.get()
    }
}