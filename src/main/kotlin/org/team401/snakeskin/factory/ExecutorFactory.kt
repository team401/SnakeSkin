package org.team401.snakeskin.factory

import java.util.concurrent.ScheduledThreadPoolExecutor

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
internal object ExecutorFactory {
    fun buildExecutor(poolSize: Int = 0) = ScheduledThreadPoolExecutor(poolSize)

    fun buildSubsystemExecutor() = buildExecutor().apply {
        maximumPoolSize = corePoolSize
    }
}