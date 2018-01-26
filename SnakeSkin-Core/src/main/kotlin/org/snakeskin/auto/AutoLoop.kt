package org.snakeskin.auto

/*
 * snakeskin - Created on 1/23/18
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 1/23/18
 */
abstract class AutoLoop {
    open val rate = 10L
    open var done = false

    abstract fun entry()
    abstract fun action()
    abstract fun exit()

    fun tick(): Boolean {
        if (!done) {
            action()
        }
        return done
    }
}