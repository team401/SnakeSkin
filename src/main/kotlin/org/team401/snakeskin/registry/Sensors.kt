package org.team401.snakeskin.registry

import org.team401.snakeskin.sensors.Sensor
import org.team401.snakeskin.sensors.SensorPoller

/*
 * snakeskin - Created on 8/18/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 8/18/17
 */

object Sensors: Registry<Sensor<*>>() {
    override fun initAll() {
        registry.forEach {
            SensorPoller.addSensor(it)
        }
    }
}