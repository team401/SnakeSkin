package org.team401.snakeskin.dsl

import org.team401.snakeskin.state.State
import org.team401.snakeskin.state.StateMachine

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

    fun state(state: String, setup: StateBuilder.() -> Unit) {
        val stateBuilder = StateBuilder(state)
        stateBuilder.setup()
        builder.addState(stateBuilder.build())
    }

    fun isInState(state: String) = builder.getState() == state
    fun wasInState(state: String) = builder.getLastState() == state
}

class StateBuilder(name: String): Builder<State> {
    private val builder = State(name, {}, {}, {})
    override fun build() = builder

    fun rejectIf(condition: () -> Boolean) {
        builder.rejectionConditions = condition
    }

    fun entry(action: () -> Unit) {
        builder.entry = action
    }

    fun action(rate: Long = 20L, action: () -> Unit) {
        builder.rate = rate
        builder.action = action
    }

    fun exit(action: () -> Unit) {
        builder.exit = action
    }
}