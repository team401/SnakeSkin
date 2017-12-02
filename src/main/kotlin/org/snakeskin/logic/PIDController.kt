package org.snakeskin.logic

import org.snakeskin.ability.AUpdatable

/*
 * snakeskin - Created on 12/2/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 12/2/17
 */

class PIDController(var p: Double = 0.0, var i: Double = 0.0, var d: Double = 0.0, var f: Double = 0.0): AUpdatable<Double> {
    var setpoint = 0.0
    @Synchronized get
    @Synchronized set

    var current = 0.0
    @Synchronized get
    @Synchronized set

    override fun update(newValue: Double) {
        current = newValue
    }
}