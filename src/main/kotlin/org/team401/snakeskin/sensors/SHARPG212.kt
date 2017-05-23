package org.team401.snakeskin.sensors

/*
 * SnakeSkin - Created on 5/22/17
 * Author: Zachary Kozar
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at the project root.
 */

import edu.wpi.first.wpilibj.AnalogInput
import org.team401.snakeskin.Unit

/**
 * @author Zachary Kozar
 * @version 5/22/17
 *
 * Wrapper class for the SHARP GP2D12 proximity sensor
 * Reads distance accurately from 10cm - 80cm
 * Default unit is Centimeters
 */
class SHARPG212(port: Int, val unit: Unit = Unit.CENTIMETERS) : DistanceSensor {

    val input = AnalogInput(port)

    override fun getDistance(): Double {
        return 29.3181 * Math.pow(input.averageVoltage, -1.1468) * 2.54 * unit.multiplier
    }
}