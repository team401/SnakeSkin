package org.team401.snakeskin.event

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
    private val priorityHandlers = hashMapOf<String, (Parameters) -> Unit>()
    private val handlers = hashMapOf<String, (Parameters) -> Unit>()
    private val executor = ScheduledThreadPoolExecutor(1)

    fun registerHandler(event: String, handler: (Parameters) -> Unit) = handlers.put(event, handler)
    internal fun registerPriority(event: String, handler: (Parameters) -> Unit) = priorityHandlers.put(event, handler)


    fun fireEvent(event: String, parameters: MutableParameters) {
        priorityHandlers.filter { it.key == event }.forEach {
            _, handler ->
            handler(parameters.toParameters()) //Call the priority handlers first, since we know they will be running in their own executors
        }
        handlers.filter { it.key == event }.forEach {
            _, handler ->
            executor.submit { handler(parameters.toParameters()) } //Run these handlers in our executor so they don't tie up the caller
        }
    }
}