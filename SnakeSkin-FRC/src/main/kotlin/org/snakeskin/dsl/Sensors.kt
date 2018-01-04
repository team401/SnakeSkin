package org.snakeskin.dsl

import edu.wpi.first.wpilibj.AnalogInput
import edu.wpi.first.wpilibj.DigitalInput
import org.snakeskin.sensors.*

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
        override fun build() = sensor

        fun pollAt(rate: Long) {
            sensor.pollRate = rate
        }

        fun noPoll() {
            sensor.pollRate = -1
        }

        fun whenChanged(action: () -> Unit) {
            sensor.changedListener = action
        }
    }

    open class BooleanSensorBuilder(private val sensor: BooleanSensor): SensorBuilder<BooleanSensor>(sensor) {
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

    class DigitalSensorBuilder(private val sensor: DigitalSensor): BooleanSensorBuilder(sensor) {
        fun buildDigital() = sensor
    }

    open class NumericSensorBuilder(private val sensor: NumericSensor): SensorBuilder<NumericSensor>(sensor) {
        fun whenChanged(action: (Double) -> Unit) {
            sensor.receivingChangeListener = action
        }

        fun whenAbove(above: Double, action: () -> Unit) {
            sensor.registerWhenAboveListener(above, action)
        }

        fun whenBelow(below: Double, action: () -> Unit) {
            sensor.registerWhenBelowListener(below, action)
        }

        var deadband: Double
            get() = sensor.deadband
            set(value: Double) {sensor.deadband = value}

        var zero: Double
            get() = sensor.zero
            set(value: Double) {sensor.zero = value}
    }

    class AnalogSensorBuilder(private val sensor: AnalogSensor): NumericSensorBuilder(sensor) {
        fun whenChanged(action: (voltage: Double, value: Int, averageVoltage: Double, averageValue: Int) -> Unit) {
            sensor.analogReceivingChangeListener = action
        }

        val analogInput: AnalogInput
            get() = sensor.analogInput

        fun buildAnalog() = sensor
    }

    fun booleanSensor(getter: () -> Boolean, setup: BooleanSensorBuilder.() -> Unit = {}): BooleanSensor {
        val builder = BooleanSensorBuilder(BooleanSensor(getter = getter))
        builder.setup()
        return builder.build()
    }

    fun digitalSensor(port: Int, setup: BooleanSensorBuilder.() -> Unit = {}): DigitalSensor {
        val builder = DigitalSensorBuilder(DigitalSensor(dio = DigitalInput(port)))
        builder.setup()
        return builder.buildDigital()
    }

    fun numericSensor(getter: () -> Double, setup: NumericSensorBuilder.() -> Unit = {}): NumericSensor {
        val builder = NumericSensorBuilder(NumericSensor(getter))
        builder.setup()
        return builder.build()
    }

    fun analogSensor(port: Int, setup: AnalogSensorBuilder.() -> Unit = {}): AnalogSensor {
        val builder = AnalogSensorBuilder(AnalogSensor(AnalogInput(port)))
        builder.setup()
        return builder.buildAnalog()
    }
}
