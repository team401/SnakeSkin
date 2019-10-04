package org.snakeskin.dsl

import org.snakeskin.executor.ExceptionHandlingRunnable
import org.snakeskin.state.State
import org.snakeskin.state.StateMachine

/**
 * @author Cameron Earle
 * @version 7/4/17
 */

/**
 * Adds a state machine to the subsystem
 * Should be used within the subsystem itself
 * @param setup The function to set up the state machine.  Receives a StateMachineBuilder.  @see StateMachineBuilder
 * @param S The type of the state values.  This could be for example an enum, which would allow your IDE to auto-complete your states
 * @return The StateMachine object
 */
fun <S> Subsystem.stateMachine(setup: StateMachineBuilder<S>.() -> Unit): StateMachine<S> {
    val builder = StateMachineBuilder<S>()
    builder.setup()
    val machine = builder.build()
    addStateMachine(machine)
    return machine
}

class StateValuePair<S, V>(val state: S,
                           val value: V)

/**
 * Adds a command machine to the subsystem
 * A command machine extends the behaviour of a state machine, but provides a shorter syntax for many "command" actions
 * that only need an entry.  Provides the standard state machine builder for hybrid functionality
 *
 * @param states The map of states to values.  These values will be provided to the mapping
 * @param mapping The function to respond to a state change.  Receives the state and value from the map,
 *                and is called whenever a change to a state in the map occurs
 * @param S The type of the state
 * @param V The type of the value
 *
 * @return The StateMachine object
 */
fun <S, V> Subsystem.commandMachine(states: Map<S, V>, mapping: StateValuePair<S, V>.() -> Unit): StateMachine<S> {
    return commandMachine(states, mapping) {}
}

/**
 * Adds a command machine to the subsystem
 * A command machine extends the behaviour of a state machine, but provides a shorter syntax for many "command" actions
 * that only need an entry.  Provides the standard state machine builder for hybrid functionality
 *
 * @param states The map of states to values.  These values will be provided to the mapping
 * @param mapping The function to respond to a state change.  Receives the state and value from the map,
 *                and is called whenever a change to a state in the map occurs
 * @param setup @see stateMachine
 * @param S The type of the state.  @see stateMachine
 * @param V The type of the value
 *
 * @return The StateMachine object
 */
fun <S, V> Subsystem.commandMachine(states: Map<S, V>, mapping: StateValuePair<S, V>.() -> Unit, setup: StateMachineBuilder<S>.() -> Unit = {}): StateMachine<S> {
    val machine = stateMachine(setup) //Build a machine from the setup method
    states.forEach { (state, value) ->
        machine.addState(State(state, ExceptionHandlingRunnable { mapping(StateValuePair(state, value)) }))
    }
    return machine
}

/**
 * Adds a boolean command machine to the subsystem
 * A boolean command machine is an extension of a command machine that only accepts boolean states
 *
 * @param mapping @see commandMachine
 *
 * @return The StateMachine object
 */
fun Subsystem.booleanCommandMachine(mapping: StateValuePair<Any, Boolean>.() -> Unit): StateMachine<Any> {
    return booleanCommandMachine(mapping) {}
}

/**
 * Adds a boolean command machine to the subsystem
 * A boolean command machine is an extension of a command machine that only accepts boolean states
 *
 * @param mapping @see commandMachine
 * @param setup @see stateMachine
 *
 * @return The StateMachine object
 */
fun Subsystem.booleanCommandMachine(mapping: StateValuePair<Any, Boolean>.() -> Unit, setup: StateMachineBuilder<Any>.() -> Unit = {}): StateMachine<Any> {
    return commandMachine<Any, Boolean>(stateMap(false to false, true to true), mapping, setup)
}