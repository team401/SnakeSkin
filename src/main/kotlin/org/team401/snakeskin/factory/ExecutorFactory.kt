package org.team401.snakeskin.factory

import org.team401.snakeskin.Constants
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

    internal fun init() {
        if (Constants.USE_POOL) {
            EXECUTOR = Executors.unconfigurableScheduledExecutorService(
                    ScheduledThreadPoolExecutor(Constants.POOL_SIZE).apply {
                        setKeepAliveTime(10, TimeUnit.SECONDS)
                        allowCoreThreadTimeOut(true)
                    }
            )
        }
        //Note that EXECUTOR will never be initialized if USE_POOL is false,
        //so we have to be careful not to use it.
    }

    internal fun getExecutor(reason: String): ScheduledExecutorService {
        if (Constants.USE_POOL) {
            return EXECUTOR
        } else {
            return Executors.newSingleThreadScheduledExecutor()
        }
    }

    internal fun getSingleExecutor(reason: String) = Executors.newSingleThreadExecutor()!!
}