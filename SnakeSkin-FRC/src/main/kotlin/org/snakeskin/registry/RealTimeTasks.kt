package org.snakeskin.registry

import org.snakeskin.rt.IRealTimeExecutor
import org.snakeskin.rt.RealTimeTask
import org.snakeskin.rt.TaskRegistrationOrder
import org.snakeskin.runtime.SnakeskinRuntime

/**
 * @author Cameron Earle
 * @version 7/5/18
 *
 * Provides a familiar registry interface to register real time tasks.
 * It is just a wrapper for RealTimeExecutor's addTasks method, but it keeps consistent with library syntax
 */
object RealTimeTasks {
    /**
     * Adds a series of real time tasks to the head of the default real time executor.
     * These tasks will be run before any state machine "rtAction" blocks
     */
    fun add(vararg tasks: RealTimeTask) {
        tasks.forEach {
            SnakeskinRuntime.registerRealTimeTask(it, order = TaskRegistrationOrder.HEAD)
        }
    }

    /**
     * Adds a series of real time tasks to the tail of the default real time executor.
     * These tasks will be run after any state machine "rtAction" blocks
     */
    fun addLast(vararg tasks: RealTimeTask) {
        tasks.forEach {
            SnakeskinRuntime.registerRealTimeTask(it, order = TaskRegistrationOrder.TAIL)
        }
    }
}