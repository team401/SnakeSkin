package org.snakeskin.auto

/*
 * snakeskin - Created on 4/3/18
 * Author: Cameron Earle
 *
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * Defines a basic auto loop, with the minimum requirements for the auto executor to function.
 *
 * @author Cameron Earle
 * @version 4/3/18
 */
abstract class AutoLoop {
    open val rate = 10L
    open var done = false

    abstract fun startTasks()
    abstract fun stopTasks()

    abstract fun entry(currentTime: Double)
    abstract fun action(currentTime: Double, lastTime: Double)
    abstract fun exit(currentTime: Double)

    fun tick(currentTime: Double, lastTime: Double): Boolean {
        if (!done) {
            action(currentTime, lastTime)
        }
        return done
    }
}