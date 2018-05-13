package org.snakeskin.dsl

import org.snakeskin.logic.Parameters
import org.snakeskin.state.StateMachine
import org.snakeskin.subsystem.Subsystem

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

fun Subsystem.stateMachine(setup: StateMachineBuilder.() -> Unit): StateMachine {
    val builder = StateMachineBuilder()
    builder.setup()
    val machine = builder.build()
    addStateMachine(machine)
    return machine
}