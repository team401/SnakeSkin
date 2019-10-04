package org.snakeskin.dsl

import org.snakeskin.event.EventRouter
import org.snakeskin.executor.ExceptionHandlingRunnable

/**
 * @author Cameron Earle
 * @version 7/4/17
 */

/**
 * Sends an event on the event router
 * @param name The event to send
 */
fun send(name: Any) {
    EventRouter.fireEvent(name)
}

/**
 * Registers an event handler
 * @param name The event to listen for
 * @param action The function to run when the event is received.
 */
fun on(name: Any, action: () -> Unit) {
    EventRouter.registerHandler(name, ExceptionHandlingRunnable(action))
}