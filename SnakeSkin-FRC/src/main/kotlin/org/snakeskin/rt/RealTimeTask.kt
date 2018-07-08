package org.snakeskin.rt

/**
 * Implements a task that should be run in "real-time", meaning the rate at which it is called is continuous,
 * and the tasks inside are fixed time (or as close as possible).  Blocking should be avoided in real time tasks
 */
interface RealTimeTask {
    val name: String
    fun action(ctx: RealTimeExecutor.RealTimeContext)
}