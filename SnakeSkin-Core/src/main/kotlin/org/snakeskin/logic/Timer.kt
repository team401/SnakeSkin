package org.snakeskin.logic

import org.snakeskin.ability.ATickable
import org.snakeskin.ability.AUpdatable

/*
 * snakeskin - Created on 12/26/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 12/26/17
 */

class Timer {
    var last = 0L
    var running = false; private set

    fun start() {
        running = true
        last = System.currentTimeMillis()
    }

    fun stop(): Long {
        running = false
        return System.currentTimeMillis() - last
    }

    fun reset() {
        running = false
        last = 0L
    }


    fun check(time: Long): Boolean {
        if (!running) start()
        return (System.currentTimeMillis() - last) >= time
    }
}