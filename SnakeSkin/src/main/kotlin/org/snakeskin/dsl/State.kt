package org.snakeskin.dsl

import edu.wpi.first.wpilibj.Sendable
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

    fun state(state: String, setup: MutableStateBuilder.() -> Unit) {
        val stateBuilder = MutableStateBuilder(state)
        stateBuilder.setup()
        builder.addState(stateBuilder.build())
    }

    fun disabled(setup: StateBuilder.() -> Unit) {
        val stateBuilder = StateBuilder(States.DISABLED)
        stateBuilder.setup()
        builder.addState(stateBuilder.build())
    }

    fun default(setup: StateBuilder.() -> Unit) {
        val stateBuilder = StateBuilder(States.ELSE)
        stateBuilder.setup()
        builder.elseCondition = stateBuilder.build()
    }

    @Suppress("UNCHECKED_CAST")
    fun publish(vararg pairs: Pair<Function0<*>, String>) {
        for (pair in pairs) {
            try {
                builder.publisher.publishNumber(pair.second, pair.first as () -> Number)
                continue
            } catch (e: ClassCastException) {}
            try {
                builder.publisher.publishString(pair.second, pair.first as () -> String)
                continue
            } catch (e: ClassCastException) {}
            try {
                builder.publisher.publishBoolean(pair.second, pair.first as () -> Boolean)
                continue
            } catch (e: ClassCastException) {}
            try {
                builder.publisher.publishSendable(pair.second, pair.first as () -> Sendable)
                continue
            } catch (e: ClassCastException) {}
            throw IllegalArgumentException("Cannot publish '${pair.second}', invalid type")
        }
    }

    fun isInState(state: String) = builder.getState() == state
    fun wasInState(state: String) = builder.getLastState() == state
    fun setState(state: String) = builder.setState(state)
}

open class StateBuilder(name: String): Builder<State> {
    protected val builder = State(name, StateMachine.EMPTY_LAMBDA, StateMachine.EMPTY_LAMBDA, StateMachine.EMPTY_LAMBDA)
    override fun build() = builder

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

class MutableStateBuilder(name: String): StateBuilder(name) {
    fun rejectIf(condition: () -> Boolean) {
        builder.rejectionConditions = condition
    }

    fun timeout(timeout: Long, timeoutTo: String) {
        builder.timeout = timeout
        builder.timeoutTo = timeoutTo
    }
}