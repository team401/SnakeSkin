package org.snakeskin.registry

import org.snakeskin.rt.RealTimeExecutor
import org.snakeskin.rt.RealTimeTask

/**
 * @author Cameron Earle
 * @version 7/5/18
 *
 * Provides a familiar registry interface to register real time tasks.
 * It is just a wrapper for RealTimeExecutor's addTasks method, but it keeps consistent with library syntax
 */
object RealTimeTasks {
    fun add(vararg tasks: RealTimeTask) {
        tasks.forEach {
            RealTimeExecutor.addTask(it)
        }
    }
}