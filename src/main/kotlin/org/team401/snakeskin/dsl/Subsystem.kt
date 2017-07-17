package org.team401.snakeskin.dsl

import org.team401.snakeskin.exception.ParameterNotFoundException
import org.team401.snakeskin.logic.MutableParameters
import org.team401.snakeskin.logic.Parameters
import org.team401.snakeskin.subsystem.Subsystem
import java.util.concurrent.ConcurrentHashMap

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

infix fun Subsystem.toState(state: String) {
    setState(state)
}

infix fun Subsystem.toMode(mode: String) {
    setActiveMode(mode)
}

fun subsystem(setup: SubsystemBuilder.() -> Unit): Subsystem {
    val builder = SubsystemBuilder()
    builder.setup()
    return builder.build()
}

class SubsystemBuilder {
    private val builder = Subsystem().MODIFIER

    var MODE: String
    get() = builder.subsystem.getActiveMode()
    set(value) = builder.subsystem.setActiveMode(value)

    var STATE: String
    get() = ""
    set(value) = builder.setStateInternally(value)

    fun setup(action: () -> Unit) {
        builder.registerSetupTasks(action)
    }

    fun state(state: String, action: () -> Unit) {
        builder.registerState(state, action)
    }

    fun on(event: String, action: Parameters.() -> Unit) {
        builder.registerEventHandler(event, action)
    }

    fun loop(rate: Long = 20L, action: () -> Unit) {
        builder.registerLoop(rate, action)
    }

    fun build() = builder.subsystem
}