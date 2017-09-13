package org.team401.snakeskin.sensors

import edu.wpi.first.wpilibj.DigitalInput
import org.team401.snakeskin.sensors.BooleanSensor

/*
 * snakeskin - Created on 9/11/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 9/11/17
 */

open class DigitalSensor(override var inverted: Boolean = false, dio: DigitalInput): BooleanSensor(inverted, {dio.get()})