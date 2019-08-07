package org.snakeskin.factory

import org.snakeskin.executor.ExceptionHandlingScheduledExecutor
import java.util.concurrent.*

/**
 * @author Cameron Earle
 * @version 7/20/17
 */
object ExecutorFactory {
    const val POOL_SIZE = 8

    private lateinit var executor: ScheduledExecutorService

    internal fun init() {
        executor = Executors.unconfigurableScheduledExecutorService(
                ExceptionHandlingScheduledExecutor(POOL_SIZE, DaemonThreadFactory).apply {
                    setKeepAliveTime(10, TimeUnit.SECONDS)
                    allowCoreThreadTimeOut(true)
                }
        )
    }

    private fun newSingleThreadScheduledExecutor() = Executors.unconfigurableScheduledExecutorService(
            ExceptionHandlingScheduledExecutor(1, DaemonThreadFactory)
    )

    @Suppress("UNUSED_PARAMETER") //We plan to use 'reason' in the future
    fun getExecutor(reason: String) = executor

    @Suppress("UNUSED_PARAMETER") //We plan to use 'reason' in the future
    fun getSingleExecutor(reason: String) = newSingleThreadScheduledExecutor()!!

    fun getExecutor() = executor
}