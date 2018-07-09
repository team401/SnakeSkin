package org.snakeskin.registry

import org.snakeskin.annotation.PostStartup
import org.snakeskin.sensors.Sensor
import org.snakeskin.sensors.SensorPoller

/**
 * @author Cameron Earle
 * @version 12/24/17
 */
object Sensors: Registry<Sensor<*>>() {
    @PostStartup @JvmStatic fun initAll() {
        registry.forEach {
            SensorPoller.addSensor(it)
        }
    }
}