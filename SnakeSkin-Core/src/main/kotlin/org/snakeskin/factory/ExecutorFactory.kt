package org.snakeskin.factory

import org.snakeskin.SnakeskinConstants
import org.snakeskin.annotation.PreStartup
import java.util.concurrent.*

/*
 * snakeskin - Created on 7/20/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 7/20/17
 */
object ExecutorFactory {
    private lateinit var EXECUTOR: ScheduledExecutorService

    @PreStartup @JvmStatic internal fun init() {
        if (SnakeskinConstants.USE_POOL) {
            EXECUTOR = Executors.unconfigurableScheduledExecutorService(
                    ScheduledThreadPoolExecutor(SnakeskinConstants.POOL_SIZE, LoggedThreadFactory).apply {
                        setKeepAliveTime(10, TimeUnit.SECONDS)
                        allowCoreThreadTimeOut(true)
                    }
            )
        }
        //Note that EXECUTOR will never be initialized if USE_POOL is false,
        //so we have to be careful not to use it.
    }

    @Suppress("UNUSED_PARAMETER") //We plan to use 'reason' in the future
    fun getExecutor(reason: String): ScheduledExecutorService {
        if (SnakeskinConstants.USE_POOL) {
            return EXECUTOR
        } else {
            return Executors.newSingleThreadScheduledExecutor(LoggedThreadFactory)
        }
    }

    @Suppress("UNUSED_PARAMETER") //We plan to use 'reason' in the future
    fun getSingleExecutor(reason: String) = Executors.newSingleThreadScheduledExecutor(LoggedThreadFactory)!!
}