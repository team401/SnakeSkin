package org.team401.snakeskin.event

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
    private val priorityHandlers = hashMapOf<String, (Event) -> Unit>()
    private val handlers = hashMapOf<String, (Event) -> Unit>()
    private val executor = ScheduledThreadPoolExecutor(1)

    fun registerHandler(event: String, handler: (Event) -> Unit) = handlers.put(event, handler)
    fun registerPriority(event: String, handler: (Event) -> Unit) = priorityHandlers.put(event, handler)


    fun fireEvent(event: String, parameters: Event) {
        priorityHandlers.filter { it.key == event }.forEach {
            _, handler ->
            handler(parameters) //Call the priority handlers first, since we know they will be running in their own executors
        }
        handlers.filter { it.key == event }.forEach {
            _, handler ->
            executor.submit { handler(parameters) } //Run these handlers in our executor so they don't tie up the caller
        }
    }
}