package org.snakeskin.sensors

import org.snakeskin.factory.ExecutorFactory
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.TimeUnit

/**
 * @author Cameron Earle
 * @version 9/10/17
 */
object SensorPoller {
    private val EXECUTOR = ExecutorFactory.getExecutor("SensorPoller")

    fun addSensor(sensor: Sensor<*>) {
        if (sensor.pollRate != -1L) {
            EXECUTOR.scheduleAtFixedRate(sensor::pollImpl, 0L, sensor.pollRate, TimeUnit.MILLISECONDS)
        }
    }
}