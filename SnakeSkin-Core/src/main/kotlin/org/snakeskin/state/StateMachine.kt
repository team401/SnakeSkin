package org.snakeskin.state

import org.snakeskin.ability.IWaitable
import org.snakeskin.executor.ExceptionHandlingRunnable
import org.snakeskin.executor.IExecutorTaskHandle
import org.snakeskin.logic.NullWaitable
import org.snakeskin.logic.TickedWaitable
import org.snakeskin.logic.WaitableFuture
import org.snakeskin.measure.Seconds
import org.snakeskin.runtime.SnakeskinRuntime
import org.snakeskin.subsystem.States
import org.snakeskin.utility.value.HistoryValue
import java.util.concurrent.locks.ReentrantLock

/**
 * @author Cameron Earle
 * @version 8/3/17
 *
 * The type parameter (T) is really just a mask
 * that allows your IDE to fill in state names for you
 * and ensure that you don't put the wrong state name in the wrong place
 */
class StateMachine<T> {
    private val executor = SnakeskinRuntime.primaryExecutor

    private val states = hashMapOf<Any, State<*>>() //List of states that this state machine has
    private val globalRejections = hashMapOf<List<*>, () -> Boolean>() //Map of global rejection conditions for specific states

    private var registered = false //Becomes true once the parent subsystem calls "register".  Prevents disabled subsystems from running.

    init {
        //Register default state implementations
        states[States.DISABLED] = State(States.DISABLED)
    }

    /**
     * Adds a global rejection to the state machine, which will
     * reject all of the given states if the condition is met
     *
     * If no states are passed, the rejection condition will reject ALL states if the condition is met
     * Note that this case will also prevent your state machine from disabling, so be careful when using this.
     *
     * Makes cleaner syntax for rejecting a bunch of states for one reason
     */
    fun addGlobalRejection(states: List<T>, condition: () -> Boolean) {
        globalRejections[states] = condition
    }

    private fun isGloballyRejected(state: Any): Boolean {
        for (pair in globalRejections) {
            if (pair.key.isEmpty() || pair.key.contains(state)) { //If this key-value pair contains the given state OR the list is empty (reject ALL)
                if (pair.value()) { //If this pair's rejection case evaluates true
                    return true
                }
            }
        }

        return false //State is not rejected
    }

    private fun checkSwitchConditions(stateName: Any): Boolean {
        if (!registered) return false //Do not allow transitions on non-registered machines
        if (stateName == activeState?.name) return false //Do not allow transitions to the same state
        val state = states[stateName] ?: return false //Do not allow transitions to a state which isn't defined

        //Evaluate rejection conditions for the incoming state
        if (isGloballyRejected(stateName)) return false
        if (state.rejectionConditions()) return false

        return true //Switching is permitted
    }

    /**
     * Adds a state to this state machine
     * @param state The state to add
     */
    fun addState(state: State<*>) {
        states[state.name as Any] = state
    }

    private var activeState: State<*>? = null
    private var activeTimeoutHandle: IExecutorTaskHandle? = null //Represents the timeout that the state machine is currently running

    private val stateHistory = HistoryValue<Any?>(null) //State logic ignores T

    private fun startTransition(desiredState: Any): Boolean {
        if (!checkSwitchConditions(desiredState)) {
            return false //Do not transition if conditions are not met
        }

        activeTimeoutHandle?.stopTask(true) //Stop any potential timeouts
        activeState?.actionManager?.stopAction() //Stop the currently running action loop.
        return true
    }

    private fun finishTransition(state: Any, waitable: TickedWaitable?) {
        activeState?.actionManager?.awaitDone() //Wait for the current action loop to finish (this is re-entrant safe)

        activeState?.exit?.run() //Run the exit and wait

        activeState = states[state] //Update the active state to the new state
        stateHistory.update(activeState!!.name) //Update the state history to the new state

        activeState?.entry?.run()
        waitable?.tick()

        if (activeState?.timeout?.value != -1.0) {
            activeTimeoutHandle = executor.scheduleSingleTask(ExceptionHandlingRunnable {
                activeState?.timeoutTo?.let { setStateInternal(it, false) }
            }, activeState?.timeout ?: 0.0.Seconds)
        }

        activeState?.actionManager?.startAction()
    }

    internal fun register() {
        registered = true
        states.forEach { (_, state) ->
            state.actionManager.register()
        }
    }

    private fun setStateAny(state: Any): IWaitable {
        if (startTransition(state)) {
            val waitable = TickedWaitable()
            executor.scheduleSingleTaskNow(ExceptionHandlingRunnable { finishTransition(state, waitable) })
            return waitable
        }
        return NullWaitable
    }

    internal fun setStateInternal(state: Any, async: Boolean) {
        if (startTransition(state)) {
            if (async) {
                executor.scheduleSingleTaskNow(ExceptionHandlingRunnable { finishTransition(state, null) })
            } else {
                finishTransition(state, null)
            }
        }
    }

    internal fun disableInternal(async: Boolean) {
        if (startTransition(States.DISABLED)) {
            if (async) {
                executor.scheduleSingleTaskNow(ExceptionHandlingRunnable { finishTransition(States.DISABLED, null) })
            } else {
                finishTransition(States.DISABLED, null)
            }
        }
    }

    internal fun backInternal(async: Boolean) {
        val lastState = getLastState()
        if (startTransition(lastState)) {
            if (async) {
                executor.scheduleSingleTaskNow(ExceptionHandlingRunnable { finishTransition(lastState, null) })
            } else {
                finishTransition(lastState, null)
            }
        }
    }

    /**
     * Sets the state of this machine to the given state.
     * If the machine is already in the given state, no action is taken.
     * @param state The state to switch to
     * @return A waitable object that unblocks when the state's "entry" finishes
     */
    fun setState(state: T) = setStateAny(state as Any)

    /**
     * Returns the state machine to the state it was in previously
     */
    fun back() = setStateAny(getLastState())

    /**
     * Sets the state machine to the built in "disabled" state
     */
    fun disable() = setStateAny(States.DISABLED)

    /**
     * Gets the state that the machine is currently in
     * Note that this value is not updated during a state change until the "exit" method of the previous state finishes
     * @return The state that the machine is currently in
     */
    @Synchronized fun getState() = stateHistory.current ?: States.ELSE

    /**
     * Gets the state that the machine was in last
     * Note that this value is not updated during a state change until the "exit" method of the previous state finishes
     * @return The state that the machine was last in
     */
    @Synchronized fun getLastState() = stateHistory.last ?: States.ELSE

    /**
     * Checks if a machine is in the given state
     * @param state The state to check
     * @return true if the machine is in this state, false otherwise
     */
    @Synchronized fun isInState(state: T) = stateHistory.current == state

    /**
     * Checks if a machine was in the given state
     * @param state The state to check
     * @return true if the machine is in this state, false otherwise
     */
    @Synchronized fun wasInState(state: T) = stateHistory.last == state

    /**
     * Toggles between two states.
     * The logic is as follows:
     * If the machine is in state1, switch to state2.  Otherwise, switch to state1
     * This means that if the machine is in any other state than state1, it will switch to state1.
     * @param state1 State 1 to toggle
     * @param state2 State 2 to toggle
     * @return The waitable of whatever state was switched to
     */
    @Synchronized fun toggle(state1: T, state2: T): IWaitable {
        return if (getState() == state1) {
            setState(state2)
        } else {
            setState(state1)
        }
    }
}