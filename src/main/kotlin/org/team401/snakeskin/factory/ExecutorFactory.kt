package org.team401.snakeskin.factory

import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit

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
        EXECUTOR = Executors.unconfigurableScheduledExecutorService(
                ScheduledThreadPoolExecutor(16).apply {
                    setKeepAliveTime(10, TimeUnit.SECONDS)
                    allowCoreThreadTimeOut(true)
                }
        )
    }

    internal fun getExecutor(reason: String) = EXECUTOR
}