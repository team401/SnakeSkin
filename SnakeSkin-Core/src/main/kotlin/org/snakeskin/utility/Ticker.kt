package org.snakeskin.utility

import org.snakeskin.units.TimeUnit
import org.snakeskin.units.measure.time.TimeMeasure

/**
 * @author Cameron Earle
 * @version 8/25/18
 *
 * A ticker is an object that handles counting some quantity, either an index or a time, to determine whether or not an
 * action should occur.  It is particularly useful for debouncing, as well as for delaying actions in a real-time context
 *
 * @param condition The condition to evaluate.  Returning true will cause the ticker to increment, returning false will cause the ticker to reset
 * @param threshold The number of ticks that need to be reached until the ticker will be considered "complete"
 */
class Ticker(private val condition: () -> Boolean, private val threshold: Long) {

    /**
     * Time constructor, used to convert times into ticks
     *
     * @param condition The condition to evaluate.  Returning true will cause the ticker to increment, returning false will cause the ticker to reset
     * @param timeThreshold The threshold of time that needs to be reached until the ticker will be considered "complete"
     * @param timeInterval The interval in which the ticker's "check" function will be called.  Note that for performance reasons the ticker is not
     * tracking time for you, and thus it is your job as the caller to ensure that you are maintaining the interval
     *
     */
    constructor(condition: () -> Boolean, timeThreshold: TimeMeasure, timeInterval: TimeMeasure) : this(condition,
            (timeThreshold.toUnit(TimeUnit.Standard.MILLISECONDS).value / timeInterval.toUnit(TimeUnit.Standard.MILLISECONDS).value).toLong()
    )

    /**
     * The number of currently evaluated ticks.  When this equals "max", the check condition is true
     */
    var ticks = 0L
    private set
    @Synchronized get

    private fun checkAndIncrement() {
        if (condition()) {
            ticks++
            if (ticks > threshold) ticks = threshold //clamp to max
        } else {
            ticks = 0L
        }
    }

    /**
     * Resets the tick counter to 0
     */
    @Synchronized fun reset() {
        ticks = 0L
    }

    /**
     * Checks the condition, and if applicable updates the ticker.
     * If the ticker is at the threshold, this function returns true
     */
    @Synchronized fun check(): Boolean {
        checkAndIncrement()
        return ticks >= threshold
    }

    /**
     * Checks the condition, and if applicable updates the ticker.
     * Runs the provided action if the ticker is at the threshold
     */
    @Synchronized inline fun check(action: () -> Unit) {
        if (check()) action()
    }
}