package org.team401.snakeskin.dsl

import org.team401.snakeskin.event.Event
import org.team401.snakeskin.subsystem.Subsystem

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

fun subsystem(setup: SubsystemBuilder.() -> Unit): Subsystem {
    val builder = SubsystemBuilder()
    builder.setup()
    return builder.build()
}

class SubsystemBuilder {
    private val subsystem = Subsystem()

    fun on(event: String, action: Event.() -> Unit) {
        subsystem.registerEventHandler(event, action)
    }

    fun loop(rate: Long = 20L, action: () -> Unit) {
        subsystem.registerLoop(rate, action)
    }

    fun build() = subsystem
}