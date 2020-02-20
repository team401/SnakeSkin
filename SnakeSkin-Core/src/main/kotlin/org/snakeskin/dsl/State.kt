package org.snakeskin.dsl

import org.snakeskin.executor.ExceptionHandlingRunnable
import org.snakeskin.measure.Seconds
import org.snakeskin.measure.time.TimeMeasureSeconds
import org.snakeskin.state.*
import org.snakeskin.state.StateMachine
import org.snakeskin.subsystem.States
import kotlin.concurrent.timerTask

/**
 * @author Cameron Earle
 * @version 8/16/17
 */

@DslMarker
annotation class DslMarkerState

open class StateMachineBuilderContext<T> {
    internal val machine = StateMachine<T>()

    /**
     * Checks if the machine is in the state given
     * @param state The state to check
     * @return true if the machine is in the state, false otherwise
     */
    fun isInState(state: T) = machine.isInState(state)

    /**
     * Checks if the machine was in the state given
     * @param state The state to check
     * @return true if the machine was in the state, false otherwise
     */
    fun wasInState(state: T) = machine.wasInState(state)
}

@DslMarkerState
class StateMachineBuilder<T>: StateMachineBuilderContext<T>() {
    /**
     * Rejects all of the given states if the condition is met
     * @param states The states to reject
     * @param condition The condition to reject on
     */
    fun rejectAllIf(vararg states: T, condition: () -> Boolean) {
        machine.addGlobalRejection(states.toList(), condition)
    }

    /**
     * Adds a state to the state machine
     * @param state The name of the state to add
     * @param setup The function responsible for building the state.  @see MutableStateBuilder
     */
    fun state(state: T, setup: MutableStateBuilder<T>.() -> Unit) {
        val stateBuilder = MutableStateBuilder(state, machine)
        stateBuilder.setup()
        machine.addState(stateBuilder.state)
    }

    /**
     * Adds the "disabled" state to the machine
     * @see state
     */
    fun disabled(setup: StateBuilder<String>.() -> Unit) {
        val stateBuilder = StateBuilder(States.DISABLED, machine)
        stateBuilder.setup()
        machine.addState(stateBuilder.state)
    }
}

/**
 * Builds a State object
 */
@DslMarkerState
open class StateBuilder<T>(name: T, protected val machine: StateMachine<*>) {
    @DslMarkerState
    inner class Context(val async: Boolean) {
        /**
         * Sets the state of this machine
         * @param state The state to set
         */
        fun setState(state: T) = this@StateBuilder.machine.setStateInternal(state as Any, async)

        /**
         * Sets the machine to the disabled state
         */
        fun disable() = this@StateBuilder.machine.disableInternal(async)

        /**
         * Sets the machine to the state it was last in
         */
        fun back() = this@StateBuilder.machine.backInternal(async)
    }

    internal val state = State(name)

    /**
     * Adds the entry method to the state
     * @param entryBlock The function to run on the state's entry
     */
    fun entry(entryBlock: Context.() -> Unit) {
        val context = Context(false)
        state.entry = ExceptionHandlingRunnable { context.entryBlock() }
    }

    /**
     * Adds the action method to the state
     * @param rate The rate, in ms, to run the action loop at
     * @param actionBlock The function to run on the state's loop
     */
    fun action(rate: TimeMeasureSeconds = TimeMeasureSeconds(0.02), actionBlock: Context.() -> Unit) {
        val context = Context(false)
        state.actionManager = DefaultStateActionManager({ context.actionBlock() }, rate)
    }

    /**
     * Adds a "real-time" action method to the state.  This action will be run on a real time executor instead of the default
     * @param executorName The name of the real-time executor to use.  If not provided, the default RT executor is used
     * @param rtActionBlock The function to run on the state's loop.  The first parameter is the timestamp, the second is the dt
     */
    fun rtAction(executorName: String? = null, rtActionBlock: Context.(timestamp: TimeMeasureSeconds, dt: TimeMeasureSeconds) -> Unit) {
        val context = Context(true)
        state.actionManager = RealTimeStateActionManager({ t, d -> context.rtActionBlock(t, d) }, executorName, state.name.toString())
    }

    /**
     * Adds a ticked action method to the state.  This action will check the given condition,
     * and if it evaluates to true for the given time threshold, then the action block will be executed
     * @param timeThreshold The amount of time the condition must evaluate to true for before the action runs
     * @param condition The condition to check.  Must return a boolean.
     * @param actionBlock The function to run once the condition has evaluated to true.  This function will run continuously after this.
     * @param rate The rate at which to check the condition and execute the loop at.  Defaults to 20 milliseconds.
     */
    fun tickedAction(timeThreshold: TimeMeasureSeconds, condition: () -> Boolean, actionBlock: Context.() -> Unit, rate: TimeMeasureSeconds = TimeMeasureSeconds(0.02)) {
        val context = Context(false)
        state.actionManager = TickedActionManager(condition, { context.actionBlock() }, timeThreshold, rate)
    }

    /**
     * Adds the exit method to the state
     * @param exitBlock The function to run on the state's exit
     */
    fun exit(exitBlock: Context.() -> Unit) {
        val context = Context(false)
        state.exit = ExceptionHandlingRunnable { context.exitBlock() }
    }

    /**
     * Accessor for the rate at which the action loop of this state runs
     */
    val actionRate: TimeMeasureSeconds
    get() = state.actionManager.rate
}

/**
 * Adds functionality to the StateBuilder, with certain special functions that can't be used in default or disabled states
 */
@DslMarkerState
class MutableStateBuilder<T>(name: T, machine: StateMachine<*>): StateBuilder<T>(name, machine) {
    /**
     * Adds rejection conditions for this state.
     * @param condition The function to run to check the conditions.  Should return true if the state change should be rejected
     */
    fun rejectIf(condition: () -> Boolean) {
        state.rejectionConditions = condition
    }

    /**
     * Sets up the timeout for this state
     * @param timeout The time to wait for the timeout
     * @param timeoutTo The name of the state to timeout to
     */
    fun timeout(timeout: TimeMeasureSeconds, timeoutTo: T) {
        state.timeout = timeout
        state.timeoutTo = timeoutTo as Any
    }

    /**
     * Sets out the timeout for this state to transition to disabled
     * @param timeout The time to wait for the timeout
     */
    fun timeoutToDisabled(timeout: TimeMeasureSeconds) {
        state.timeout = timeout
        state.timeoutTo = States.DISABLED
    }
}

/**
 * Creates a map that forces the input type S and output type V, which mapOf doesn't
 * Essentially makes type inference work in command machines
 */
fun <S, V> stateMap(vararg pairs: Pair<S, V>): Map<S, V> {
    return mapOf(*pairs)
}