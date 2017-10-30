package org.snakeskin.sensors.hardware

/*
 * SnakeSkin - Created on 5/22/17
 * Author: Zachary Kozar
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at the project root.
 */

import edu.wpi.first.wpilibj.AnalogInput
import org.snakeskin.sensors.AnalogSensor
import org.snakeskin.sensors.DistanceSensor

/**
 * @author Zachary Kozar
 * @version 5/22/17
 *
 * Wrapper class for the SHARP GP2D12 proximity sensor
 * Reads distance accurately from 10cm - 80cm
 * Default unit is Centimeters
 */
class SHARPG212(port: Int): AnalogSensor(AnalogInput(port)), DistanceSensor {

    override fun getInches(): Double {
        return 29.3181 * Math.pow(getAveragedVoltage(), -1.1468)
    }

    override fun getFeet() = getInches() / 12.0

    override fun getYards() = getFeet() / 3.0
}