package org.team401.snakeskin.dsl

import org.team401.snakeskin.event.Event
import org.team401.snakeskin.event.EventRouter

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

fun send(name: String, setup: Event.() -> Unit = {}) {
    val event = Event(hashMapOf(), hashMapOf(), hashMapOf(), hashMapOf())
    event.setup()
    EventRouter.fireEvent(name, event)
}

fun on(name: String, action: Event.() -> Unit) {
    EventRouter.registerHandler(name, action)
}