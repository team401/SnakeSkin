package org.team401.snakeskin.subsystem

import org.team401.snakeskin.component.Component
import org.team401.snakeskin.event.Event
import org.team401.snakeskin.event.EventRouter
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit

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
open class Subsystem {
    val executor = ScheduledThreadPoolExecutor(1) //This subsystem's executor.  All subsystem tasks should be run on this

    val components = hashMapOf<String, Component>()

    fun registerLoop(rate: Long, action: () -> Unit) {
        executor.scheduleAtFixedRate(action, 0, rate, TimeUnit.MILLISECONDS)
    }

    fun registerEventHandler(event: String, action: (Event) -> Unit) {
        EventRouter.registerPriority(event) { //Register a priority handler
            executor.submit { //Run the task in our executor
                action(it) //Run the action with the event from the router
            }
        }
    }
}