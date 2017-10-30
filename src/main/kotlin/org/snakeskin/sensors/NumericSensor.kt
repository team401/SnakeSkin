package org.snakeskin.sensors

import org.snakeskin.logic.ComparableDoubleHistory
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

open class NumericSensor(private val getter: () -> Double, open var deadband: Double = 0.0, open var zero: Double = 0.0): Sensor<Double>()  {
    override fun read() = getter()
    protected val history = ComparableDoubleHistory()
    override var changedListener = {}
    var receivingChangeListener: (Double) -> Unit = {}
    private val whenAboveListeners = ConcurrentHashMap<Double, () -> Unit>()
    private val whenBelowListeners = ConcurrentHashMap<Double, () -> Unit>()

    fun registerWhenAboveListener(whenAbove: Double, listener: () -> Unit) = whenAboveListeners.put(whenAbove, listener)
    fun registerWhenBelowListener(whenBelow: Double, listener: () -> Unit) = whenBelowListeners.put(whenBelow, listener)

    open fun getValue() = read() - zero

    open fun zero() {
        zero = read()
    }

    override fun pollImpl() {
        history.update(getValue())

        if (history.changedWithin(deadband)) {
            changedListener()
            receivingChangeListener(history.current!!)
        }

        whenAboveListeners.forEach { value, listener ->
            if (history.wentAbove(value)) {
                listener()
            }
        }

        whenBelowListeners.forEach { value, listener ->
            if (history.wentBelow(value)) {
                listener()
            }
        }
    }
}