package org.team401.snakeskin.dsl

import org.team401.snakeskin.logic.Parameters
import org.team401.snakeskin.state.StateMachine
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

fun Subsystem.machine(machine: String) = getStateMachine(machine)

fun buildSubsystem(setup: SubsystemBuilder.() -> Unit): Subsystem {
    val builder = SubsystemBuilder()
    builder.setup()
    return builder.build()
}

class SubsystemBuilder: Builder<Subsystem> {
    private val builder = Subsystem()

    fun setup(action: () -> Unit) {
        builder.addSetupTask(action)
    }

    fun on(event: String, action: Parameters.() -> Unit) {
        builder.addEventHandler(event, action)
    }

    fun stateMachine(machine: String, setup: StateMachineBuilder.() -> Unit): StateMachine {
        val sBuilder = StateMachineBuilder()
        sBuilder.setup()
        val instance = sBuilder.build()
        builder.addStateMachine(machine, instance)
        return instance
    }

    fun test(name: String, body: () -> Boolean) {

    }

    override fun build() = builder
}