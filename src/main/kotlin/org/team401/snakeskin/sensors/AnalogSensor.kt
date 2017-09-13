package org.team401.snakeskin.sensors

import edu.wpi.first.wpilibj.AnalogInput
import org.team401.snakeskin.logic.ComparableDoubleHistory
import java.util.concurrent.ConcurrentHashMap

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

open class AnalogSensor(val analogInput: AnalogInput, var deadband: Double = 0.0): Sensor<Double>() {
    override fun read() = analogInput.voltage

    fun getVoltage() = read()
    fun getRawValue() = analogInput.value
    fun getAveragedVoltage() = analogInput.averageVoltage
    fun getAveragedValue() = analogInput.averageValue

    override var changedListener = {}
    var receivingChangeListener: (voltage: Double, value: Int, averagedVoltage: Double, averagedValue: Int) -> Unit = { _, _, _, _ -> }
    private val whenAboveListeners = ConcurrentHashMap<Double, () -> Unit>()
    private val whenBelowListeners = ConcurrentHashMap<Double, () -> Unit>()

    fun registerWhenAboveListener(whenAbove: Double, listener: () -> Unit) = whenAboveListeners.put(whenAbove, listener)
    fun registerWhenBelowListener(whenBelow: Double, listener: () -> Unit) = whenBelowListeners.put(whenBelow, listener)

    private val valueHistory = ComparableDoubleHistory()

    override fun pollImpl() {
        valueHistory.update(read())

        if (valueHistory.changedWithin(deadband)) {
            changedListener()
            receivingChangeListener(valueHistory.current!!, getRawValue(), getAveragedVoltage(), getAveragedValue())
        }

        whenAboveListeners.forEach { value, listener ->
            if (valueHistory.current!! > value) {
                listener()
            }
        }

        whenBelowListeners.forEach { value, listener ->
            if (valueHistory.current!! < value) {
                listener()
            }
        }
    }
}