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
    if (STATE == state1) {
        STATE = state2
    } else {
        STATE = state1
    }
}

fun Subsystem.toggleMode(mode1: String, mode2: String) {
    if (MODE == mode1) {
        MODE = mode2
    } else {
        MODE = mode1
    }
}

infix fun Subsystem.isInState(state: String): Boolean {
    return STATE == state
}

infix fun Subsystem.isInMode(mode: String): Boolean {
    return STATE == mode
}

fun subsystem(setup: SubsystemBuilder.() -> Unit): Subsystem {
    val builder = SubsystemBuilder()
    builder.setup()
    return builder.build()
}

class SubsystemBuilder: Builder<Subsystem> {
    private val builder = Subsystem()

    var STATE
    get() = builder.STATE
    set(value) {
        builder.STATE = value
    }

    var MODE
    get() = builder.MODE
    set(value) {
        builder.MODE = value
    }

    fun setup(action: () -> Unit) {
        builder.addSetupTask(action)
    }

    fun state(state: String, action: () -> Unit) {
        builder.addState(state, action)
    }

    fun on(event: String, action: Parameters.() -> Unit) {
        builder.addEventHandler(event, action)
    }

    fun loop(rate: Long = 20L, action: () -> Unit) {
        builder.addLoop(rate, action)
    }

    override fun build() = builder
}