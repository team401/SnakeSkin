package org.snakeskin.sensors

import org.snakeskin.executor.ExceptionHandlingRunnable
import org.snakeskin.measure.MeasureUnitless
import org.snakeskin.runtime.SnakeskinRuntime
import java.util.concurrent.TimeUnit

/**
 * @author Cameron Earle
 * @version 9/10/17
 */
object SensorPoller {
    private val executor = SnakeskinRuntime.primaryExecutor

    fun addSensor(sensor: Sensor<*>) {
        if (sensor.pollRate > MeasureUnitless(0.0)) {
            executor.schedulePeriodicTask(ExceptionHandlingRunnable(sensor::pollImpl), sensor.pollRate)
        }
    }
}