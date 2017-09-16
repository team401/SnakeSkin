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

open class AnalogSensor(val analogInput: AnalogInput, override var deadband: Double = 0.0, override var zero: Double = 0.0, var rawZero: Int = 0): NumericSensor({analogInput.voltage}) {
    fun getVoltage() = getValue()
    fun getRawValue() = analogInput.value - rawZero
    fun getAveragedVoltage() = analogInput.averageVoltage - zero
    fun getAveragedValue() = analogInput.averageValue - rawZero

    override var changedListener = {}
    var analogReceivingChangeListener: (Double, Int, Double, Int) -> Unit = { _, _, _, _ -> }

    private val valueHistory = ComparableDoubleHistory()

    override fun zero() {
        super.zero()
        rawZero = getRawValue()
    }

    override fun pollImpl() {
        super.pollImpl()

        if (valueHistory.changedWithin(deadband)) {
            analogReceivingChangeListener(valueHistory.current!!, getRawValue(), getAveragedVoltage(), getAveragedValue())
        }
    }
}