package org.snakeskin.event

import org.snakeskin.executor.ExceptionHandlingRunnable
import org.snakeskin.runtime.SnakeskinRuntime

/**
 * @author Cameron Earle
 * @version 7/4/17
 */
object EventRouter {
    private val handlers = hashMapOf<Any, ArrayList<ExceptionHandlingRunnable>>()

    /**
     * Registers an event handler on the event router
     * @param event The event to listen for
     * @param handler The function to call when the event is received.  This lambda receives a Parameters object.  @see Parameters
     */
    @Synchronized @JvmStatic fun registerHandler(event: Any, handler: ExceptionHandlingRunnable) {
        handlers.putIfAbsent(event, arrayListOf())
        handlers[event]!!.add(handler)
    }

    /**
     * Fires an event on the event router
     * @param event The event to fire
     */
    @Synchronized @JvmStatic fun fireEvent(event: Any) {
        handlers[event]?.forEach {
            SnakeskinRuntime.executeTask(it)
        }
    }
}