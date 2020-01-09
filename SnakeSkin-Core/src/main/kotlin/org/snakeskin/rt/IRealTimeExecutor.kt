package org.snakeskin.rt

import org.snakeskin.logic.TickedWaitable
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
    fun registerTask(task: RealTimeTask, order: TaskRegistrationOrder = TaskRegistrationOrder.DEFAULT)

    /**
     * Starts the real time executor
     */
    fun start()

    /**
     * Adds a ticked waitable to a queue in the executor.  After each loop cycle is complete, the queue will be
     * iterated and each waitable will be ticked.  This can be used to synchronize actions with the end of a loop.
     */
    fun enqueueSignal(waitable: TickedWaitable)
}