package org.snakeskin.auto

import org.snakeskin.measure.time.TimeMeasureSeconds

/**
 * @author Cameron Earle
 * @version 4/3/18
 *
 * Defines a basic auto loop, with the minimum requirements for the auto executor to function.
 */
abstract class AutoLoop {
    open val rate: TimeMeasureSeconds = TimeMeasureSeconds(0.02)
    open var done = false

    abstract fun startTasks()
    abstract fun stopTasks()

    abstract fun entry(currentTime: TimeMeasureSeconds)
    abstract fun action(currentTime: TimeMeasureSeconds, lastTime: TimeMeasureSeconds)
    abstract fun exit(currentTime: TimeMeasureSeconds)

    fun tick(currentTime: TimeMeasureSeconds, lastTime: TimeMeasureSeconds): Boolean {
        if (!done) {
            action(currentTime, lastTime)
        }
        return done
    }
}