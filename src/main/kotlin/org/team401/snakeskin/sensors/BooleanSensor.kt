package org.team401.snakeskin.sensors

import org.team401.snakeskin.ability.AInvertable
import org.team401.snakeskin.ability.AReadable
import org.team401.snakeskin.logic.History

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

open class BooleanSensor(override var inverted: Boolean = false, private val getter: () -> Boolean): Sensor<Boolean>(), AInvertable {
    var triggeredListener = {}
    var untriggeredListener = {}
    private val history = History<Boolean>()

    override fun read(): Boolean {
        if (inverted)
            return !getter()
        return getter()
    }

    fun isTriggered() = read()

    override fun pollImpl() {
        history.update(read())
        if (history.current == true) {
            if (history.last == false || history.last == null) {
                triggeredListener()
            }
        }

        if (history.current == false) {
            if (history.last == true) {
                untriggeredListener()
            }
        }
    }
}