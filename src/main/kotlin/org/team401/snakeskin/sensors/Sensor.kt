package org.team401.snakeskin.sensors

import org.team401.snakeskin.Constants
import org.team401.snakeskin.ability.AReadable

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
abstract class Sensor<out T>: AReadable<T> {
    abstract internal fun pollImpl()

    var pollRate = 20L
}