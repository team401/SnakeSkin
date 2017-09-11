package org.team401.snakeskin.dsl

import org.team401.snakeskin.Constants
import org.team401.snakeskin.sensors.BooleanSensor
import org.team401.snakeskin.sensors.Sensor
import org.team401.snakeskin.sensors.SensorPoller

/*
 * snakeskin - Created on 9/10/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 9/10/17
 */

object Sensors {
    open class SensorBuilder<out T: Sensor<*>>(private val sensor: T): Builder<T> {
        override fun build(): T {
            SensorPoller.addSensor(sensor)
            return sensor
        }

        fun pollAt(rate: Long) {
            sensor.pollRate = rate
        }

        fun noPoll() {
            sensor.pollRate = -1
        }
    }

    class BooleanSensorBuilder(private val sensor: BooleanSensor): SensorBuilder<BooleanSensor>(sensor) {
        fun whenTriggered(action: () -> Unit) {
            sensor.triggeredListener = action
        }

        fun whenUntriggered(action: () -> Unit) {
            sensor.untriggeredListener = action
        }

        fun invert() {
            sensor.invert()
        }

        override fun build() = sensor
    }

    fun customBooleanSensor(getter: () -> Boolean, setup: BooleanSensorBuilder.() -> Unit = {}): BooleanSensor {
        val builder = BooleanSensorBuilder(BooleanSensor(getter = getter))
        builder.setup()
        return builder.build()
    }
}
