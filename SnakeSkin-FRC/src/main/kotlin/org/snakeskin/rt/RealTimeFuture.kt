package org.snakeskin.rt

import java.util.concurrent.Delayed
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

/**
 * @author Cameron Earle
 * @version 7/10/2018
 *
 */
class RealTimeFuture(private val task: RealTimeTask): ScheduledFuture<Any> {
    private var cancelled = false

    override fun compareTo(other: Delayed?): Int {
        return 0
    }

    override fun isDone(): Boolean {
        return false
    }

    override fun get(): Any {
        return Any()
    }

    override fun get(timeout: Long, unit: TimeUnit?): Any {
        return Any()
    }

    /**
     * Effectively removes this task from the real time executor
     */
    override fun cancel(mayInterruptIfRunning: Boolean): Boolean {
        RealTimeExecutor.removeTask(task)
        cancelled = true
        return true
    }

    override fun getDelay(unit: TimeUnit?): Long {
        return 0L
    }

    override fun isCancelled(): Boolean {
        return cancelled
    }
}
