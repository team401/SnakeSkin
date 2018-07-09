package org.snakeskin.dsl

import org.snakeskin.logic.BooleanState
import org.snakeskin.logic.Parameters
import org.snakeskin.state.State
import org.snakeskin.state.StateMachine
import org.snakeskin.subsystem.Subsystem

/**
 * @author Cameron Earle
 * @version 7/4/17
 */

/**
 * Adds a state machine to the subsystem
 * Should be used within the subsystem itself
 * @param setup The function to set up the state machine.  Receives a StateMachineBuilder.  @see StateMachineBuilder
 * @return The StateMachine object
 */
fun Subsystem.stateMachine(setup: StateMachineBuilder.() -> Unit): StateMachine {
    val builder = StateMachineBuilder()
    builder.setup()
    val machine = builder.build()
    addStateMachine(machine)
    return machine
}

class StateValuePair<T>(val state: Any,
                     val value: T)

/**
 * Adds a command machine to the subsystem
 * A command machine extends the behaviour of a state machine, but provides a shorter syntax for many "command" actions
 * that only need an entry.  Provides the standard state machine builder for hybrid functionality
 */
fun <T> Subsystem.commandMachine(states: Map<Any, T>, mapping: StateValuePair<T>.() -> Unit, setup: StateMachineBuilder.() -> Unit = {}): StateMachine {
    val machine = stateMachine(setup) //Build a machine from the setup method
    states.forEach {
        state, value ->
        machine.addState(
                org.snakeskin.state.State(
                        state,
                        { mapping(StateValuePair(state, value)) },
                        StateMachine.EMPTY_LAMBDA,
                        StateMachine.EMPTY_LAMBDA
                )
        )
    }
    return machine
}

fun Subsystem.booleanCommandMachine(mapping: StateValuePair<Boolean>.() -> Unit, setup: StateMachineBuilder.() -> Unit = {}): StateMachine {
    return commandMachine(stateMap(false to false, true to true), mapping, setup)
}