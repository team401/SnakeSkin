package org.team401.snakeskin.dsl

import org.team401.snakeskin.logic.Parameters
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

fun Subsystem.toggleState(state1: String, state2: String) {
    if (getState() == state1) {
        setState(state2)
    } else {
        setState(state1)
    }
}

fun Subsystem.toggleMode(mode1: String, mode2: String) {
    if (getMode() == mode1) {
        setMode(mode2)
    } else {
        setMode(mode1)
    }
}

infix fun Subsystem.isInState(state: String): Boolean {
    return getState() == state
}

infix fun Subsystem.isInMode(mode: String): Boolean {
    return getMode() == mode
}

fun subsystem(setup: SubsystemBuilder.() -> Unit): Subsystem {
    val builder = SubsystemBuilder()
    builder.setup()
    return builder.build()
}

class SubsystemBuilder: Builder<Subsystem> {
    private val builder = Subsystem().MODIFIER

    var MODE: String
    get() = builder.subsystem.getMode()
    set(value) = builder.subsystem.setMode(value)

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

    override fun build() = builder.subsystem
}