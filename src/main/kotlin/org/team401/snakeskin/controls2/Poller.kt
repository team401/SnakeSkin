package org.team401.snakeskin.controls2

import java.util.concurrent.ScheduledThreadPoolExecutor

/*
 * snakeskin - Created on 7/16/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 7/16/17
 */

object Poller {
    private val executor = ScheduledThreadPoolExecutor(1)

    fun init() {
        executor.prestartAllCoreThreads()
    }
}