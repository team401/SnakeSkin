package org.snakeskin.dsl

import org.snakeskin.state.State
import org.snakeskin.state.StateMachine
import org.snakeskin.subsystem.States

/*
 * snakeskin - Created on 8/16/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 8/16/17
 */

class StateMachineBuilder: Builder<StateMachine> {
    private val builder = StateMachine()
    override fun build() = builder

    /**
     * Adds a state to the state machine
     * @param state The name of the state to add
     * @param setup The function responsible for building the state.  @see MutableStateBuilder
     */
    fun state(state: Any, setup: MutableStateBuilder.() -> Unit) {
        val stateBuilder = MutableStateBuilder(state)
        stateBuilder.setup()
        builder.addState(stateBuilder.build())
    }

    /**
     * Adds the "disabled" state to the machine
     * @see state
     */
    fun disabled(setup: StateBuilder.() -> Unit) {
        val stateBuilder = StateBuilder(States.DISABLED)
        stateBuilder.setup()
        builder.addState(stateBuilder.build())
    }

    /**
     * Adds the "default" state to the machine
     * @see state
     */
    fun default(setup: StateBuilder.() -> Unit) {
        val stateBuilder = StateBuilder(States.ELSE)
        stateBuilder.setup()
        builder.elseCondition = stateBuilder.build()
    }

    /**
     * Checks if the machine is in the state given
     * @param state The state to check
     * @return true if the machine is in the state, false otherwise
     */
    fun isInState(state: Any) = builder.isInState(state)

    /**
     * Checks if the machine was in the state given
     * @param state The state to check
     * @return true if the machine was in the state, false otherwise
     */
    fun wasInState(state: Any) = builder.wasInState(state)

    /**
     * Sets the state of this machine
     * @param state The state to set
     * @return A waitable object that unblocks when the state's "entry" method finishes
     */
    fun setState(state: Any) = builder.setState(state)
}

/**
 * Builds a State object
 */
open class StateBuilder(name: Any): Builder<State> {
    protected val builder = State(name, StateMachine.EMPTY_LAMBDA, StateMachine.EMPTY_LAMBDA, StateMachine.EMPTY_LAMBDA)
    override fun build() = builder

    /**
     * Adds the entry method to the state
     * @param action The function to run on the state's entry
     */
    fun entry(action: () -> Unit) {
        builder.entry = action
    }

    /**
     * Adds the action method to the state
     * @param rate The rate, in ms, to run the action loop at
     * @param action The function to run on the state's loop
     */
    fun action(rate: Long = 20L, action: () -> Unit) {
        builder.rate = rate
        builder.action = action
    }

    /**
     * Adds the exit method to the state
     * @param action The function to run on the state's exit
     */
    fun exit(action: () -> Unit) {
        builder.exit = action
    }
}

/**
 * Adds functionality to the StateBuilder, with certain special functions that can't be used in default or disabled states
 */
class MutableStateBuilder(name: Any): StateBuilder(name) {
    /**
     * Adds rejection conditions for this state.
     * @param condition The function to run to check the conditions.  Should return true if the state change should be rejected
     */
    fun rejectIf(condition: () -> Boolean) {
        builder.rejectionConditions = condition
    }

    /**
     * Sets up the timeout for this state
     * @param timeout The time, in ms, to wait for the timeout
     * @param timeoutTo The name of the state to timeout to
     */
    fun timeout(timeout: Long, timeoutTo: Any) {
        builder.timeout = timeout
        builder.timeoutTo = timeoutTo
    }
}

/**
 * Creates a map that forces the output type T, which mapOf doesn't
 * Essentially makes type inference work in command machines
 */
fun <T> stateMap(vararg pairs: Pair<Any, T>): Map<Any, T> {
    return mapOf(*pairs)
}