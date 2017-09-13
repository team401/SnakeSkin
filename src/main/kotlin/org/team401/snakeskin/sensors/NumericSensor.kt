package org.team401.snakeskin.sensors

import org.team401.snakeskin.logic.History

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

open class NumericSensor(private val getter: () -> Double): Sensor<Double>()  {
    override fun read() = getter()
    private val history = History<Double>()
    override var changedListener = {}

    open fun getValue() = read()

    override fun pollImpl() {
        history.update(read())

        if (history.changed()) {
            changedListener()
        }
    }
}