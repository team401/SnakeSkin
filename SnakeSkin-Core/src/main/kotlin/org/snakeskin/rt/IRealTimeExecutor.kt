package org.snakeskin.rt

import org.snakeskin.measure.time.TimeMeasureSeconds

/**
 * Interface for an implementation of a Real Time executor
 */
interface IRealTimeExecutor {
    /**
     * The rate this real time executor is running at, in seconds
     */
    val rate: TimeMeasureSeconds

    /**
     * The current dt of the executor
     */
    val dt: TimeMeasureSeconds

    /**
     * Registers a task with the real time executor
     */
    fun registerTask(task: RealTimeTask)

    /**
     * Starts the real time executor
     */
    fun start()
}