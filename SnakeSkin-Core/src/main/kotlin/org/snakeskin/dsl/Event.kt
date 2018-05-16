package org.snakeskin.dsl

import org.snakeskin.logic.Parameters
import org.snakeskin.event.EventRouter
import org.snakeskin.logic.MutableParameters

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

fun send(name: Any, setup: MutableParameters.() -> Unit = {}) {
    val event = MutableParameters()
    event.setup()
    EventRouter.fireEvent(name, event)
}

fun on(name: Any, action: Parameters.() -> Unit) {
    EventRouter.registerHandler(name, action)
}