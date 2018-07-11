package org.snakeskin.executor

import org.snakeskin.factory.ExecutorFactory
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

/**
 * @author Cameron Earle
 * @version 7/10/2018
 *
 */
class ThreadPoolSchedulingContext(val task: () -> Unit, val rate: Long): SchedulingContext {
    companion object {
        private val executor = ExecutorFactory.getExecutor("ThreadPoolSchedulingContext")
    }

    override fun schedule(): ScheduledFuture<*> {
        return executor.scheduleAtFixedRate(task, 0L, rate, TimeUnit.MILLISECONDS)
    }
}