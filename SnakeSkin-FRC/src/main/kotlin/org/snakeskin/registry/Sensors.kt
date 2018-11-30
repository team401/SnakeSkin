package org.snakeskin.registry

import org.snakeskin.sensors.Sensor
import org.snakeskin.sensors.SensorPoller

/**
 * @author Cameron Earle
 * @version 12/24/17
 */
object Sensors: Registry<Sensor<*>>() {
    @JvmStatic fun initAll() {
        println("SnakeSkin-FRC: Sensors Registry Loaded") //TODO remove debug statement

        registry.forEach {
            SensorPoller.addSensor(it)
        }
    }
}