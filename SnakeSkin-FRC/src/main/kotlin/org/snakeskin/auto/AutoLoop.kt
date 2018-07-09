package org.snakeskin.auto

/**
 * @author Cameron Earle
 * @version 4/3/18
 *
 * Defines a basic auto loop, with the minimum requirements for the auto executor to function.
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