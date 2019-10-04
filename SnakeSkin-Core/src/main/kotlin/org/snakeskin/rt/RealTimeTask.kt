package org.snakeskin.rt

import org.snakeskin.measure.time.TimeMeasureSeconds
import org.snakeskin.utility.value.AsyncBoolean

/**
 * @author Cameron Earle
 * @version 9/30/2019
 *
 * Implements a task that should be run in "real-time", meaning the rate at which it is called is continuous,
 * and the tasks inside are fixed time (or as close as possible).  Blocking should be avoided in real time tasks
 */
abstract class RealTimeTask(enabledByDefault: Boolean = true) {
    val name: String
        get() = this.javaClass.simpleName

    /**
     * Whether or not the task is enabled.  Setting this to false will cause whatever RT executor that is running
     * this task to ignore it.
     */
    var enabled by AsyncBoolean(enabledByDefault)

    /**
     * The action to execute in real time
     * @param timestamp The current system timestamp, in seconds
     * @param dt The time difference between the current timestamp and the timestamp this action was last called
     */
    abstract fun action(timestamp: TimeMeasureSeconds, dt: TimeMeasureSeconds)
}