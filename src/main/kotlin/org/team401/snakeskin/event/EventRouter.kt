package org.team401.snakeskin.event

import org.team401.snakeskin.factory.ExecutorFactory
import org.team401.snakeskin.logic.MutableParameters
import org.team401.snakeskin.logic.Parameters
import java.util.concurrent.ScheduledThreadPoolExecutor

/*
 * SnakeSkin - Created on 7/4/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 7/4/17
 */
object EventRouter {
    private val priorityHandlers = hashMapOf<String, ArrayList<(Parameters) -> Unit>>()
    private val handlers = hashMapOf<String, ArrayList<(Parameters) -> Unit>>()
    private val executor = ExecutorFactory.getExecutor("Event Router")

    fun registerHandler(event: String, handler: (Parameters) -> Unit) {
        handlers.putIfAbsent(event, arrayListOf())
        handlers[event]!!.add(handler)
    }
    internal fun registerPriority(event: String, handler: (Parameters) -> Unit) {
        priorityHandlers.putIfAbsent(event, arrayListOf())
        priorityHandlers[event]!!.add(handler)
    }


    @Synchronized fun fireEvent(event: String, parameters: MutableParameters) {
        priorityHandlers[event]?.forEach {
            it(parameters.toParameters())
        }
        handlers[event]?.forEach {
            executor.submit { it(parameters.toParameters()) }
        }
    }
}