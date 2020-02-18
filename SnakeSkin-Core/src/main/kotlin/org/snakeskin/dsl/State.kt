package org.snakeskin.dsl

import org.snakeskin.executor.ExceptionHandlingRunnable
import org.snakeskin.measure.time.TimeMeasureSeconds
import org.snakeskin.state.DefaultStateActionManager
import org.snakeskin.state.RealTimeStateActionManager
import org.snakeskin.state.State
import org.snakeskin.state.StateMachine
import org.snakeskin.subsystem.States

/**
 * @author Cameron Earle
 * @version 8/16/17
 */

class StateMachineBuilder<T>: IBuilder<StateMachine<T>> {
    private val builder = StateMachine<T>()
    override fun build() = builder

    /**
     * Rejects all of the given states if the condition is met
     * @param states The states to reject
     * @param condition The condition to reject on
     */
    fun rejectAllIf(vararg states: T, condition: () -> Boolean) {
        builder.addGlobalRejection(states.toList(), condition)
    }

    /**
     * Adds a state to the state machine
     * @param state The name of the state to add
     * @param setup The function responsible for building the state.  @see MutableStateBuilder
     */
    fun state(state: T, setup: MutableStateBuilder<T>.() -> Unit) {
        val stateBuilder = MutableStateBuilder(state)
        stateBuilder.setup()
        builder.addState(stateBuilder.build())
    }

    /**
     * Adds the "disabled" state to the machine
     * @see state
     */
    fun disabled(setup: StateBuilder<String>.() -> Unit) {
        val stateBuilder = StateBuilder(States.DISABLED)
        stateBuilder.setup()
        builder.addState(stateBuilder.build())
    }

    /**
     * Checks if the machine is in the state given
     * @param state The state to check
     * @return true if the machine is in the state, false otherwise
     */
    fun isInState(state: T) = builder.isInState(state)

    /**
     * Checks if the machine was in the state given
     * @param state The state to check
     * @return true if the machine was in the state, false otherwise
     */
    fun wasInState(state: T) = builder.wasInState(state)

    /**
     * Sets the state of this machine
     * @param state The state to set
     */
    fun setState(state: T) = builder.setStateNow(state)

    /**
     * Sets the machine to the disabled state
     */
    fun disable() = builder.disableNow()

    /**
     * Sets the machine to the state it was last in
     */
    fun back() = builder.backNow()
}

/**
 * Builds a State object
 */
open class StateBuilder<T>(name: T): IBuilder<State<T>> {
    val builder = State(name)
    override fun build() = builder

    /**
     * Adds the entry method to the state
     * @param entryBlock The function to run on the state's entry
     */
    fun entry(entryBlock: () -> Unit) {
        builder.entry = ExceptionHandlingRunnable(entryBlock)
    }

    /**
     * Adds the action method to the state
     * @param rate The rate, in ms, to run the action loop at
     * @param actionBlock The function to run on the state's loop
     */
    fun action(rate: TimeMeasureSeconds = TimeMeasureSeconds(0.02), actionBlock: () -> Unit) {
        builder.actionManager = DefaultStateActionManager(actionBlock, rate)
    }

    /**
     * Adds a "real-time" action method to the state.  This action will be run on a real time executor instead of the default
     * @param executorName The name of the real-time executor to use.  If not provided, the default RT executor is used
     * @param rtActionBlock The function to run on the state's loop.  The first parameter is the timestamp, the second is the dt
     */
    fun rtAction(executorName: String? = null, rtActionBlock: (timestamp: TimeMeasureSeconds, dt: TimeMeasureSeconds) -> Unit) {
        builder.actionManager = RealTimeStateActionManager(rtActionBlock, executorName, builder.name.toString())
    }

    /**
     * Adds the exit method to the state
     * @param exitBlock The function to run on the state's exit
     */
    fun exit(exitBlock: () -> Unit) {
        builder.exit = ExceptionHandlingRunnable(exitBlock)
    }

    /**
     * Accessor for the rate at which the action loop of this state runs
     */
    val actionRate: TimeMeasureSeconds
    get() = builder.actionManager.rate
}

/**
 * Adds functionality to the StateBuilder, with certain special functions that can't be used in default or disabled states
 */
class MutableStateBuilder<T>(name: T): StateBuilder<T>(name) {
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
    fun timeout(timeout: TimeMeasureSeconds, timeoutTo: T) {
        builder.timeout = timeout
        builder.timeoutTo = timeoutTo as Any
    }
}

/**
 * Creates a map that forces the input type S and output type V, which mapOf doesn't
 * Essentially makes type inference work in command machines
 */
fun <S, V> stateMap(vararg pairs: Pair<S, V>): Map<S, V> {
    return mapOf(*pairs)
}