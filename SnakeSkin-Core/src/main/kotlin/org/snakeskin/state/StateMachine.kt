package org.snakeskin.state

import org.snakeskin.ability.IWaitable
import org.snakeskin.executor.ExceptionHandlingRunnable
import org.snakeskin.executor.IExecutorTaskHandle
import org.snakeskin.logic.NullWaitable
import org.snakeskin.logic.TickedWaitable
import org.snakeskin.logic.WaitableFuture
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

    private val states = arrayListOf<State<*>>() //List of states that this state machine has
    private val globalRejections = hashMapOf<List<*>, () -> Boolean>() //Map of global rejection conditions for specific states

    private var registered = false //Becomes true once the parent subsystem calls "register".  Prevents disabled subsystems from running.

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

    /**
     * Adds a state to this state machine
     * @param state The state to add
     */
    fun addState(state: State<*>) = states.add(state)

    /**
     * The state to go to when a state change is requested for a state that doesn't exist
     */
    var elseCondition = State(States.ELSE)

    private var activeState: State<*>? = null
    private var activeActionManager: IStateActionManager? = null //Represents whatever task the state machine is currently running
    private var activeTimeoutHandle: IExecutorTaskHandle? = null //Represents the timeout that the state machine is currently running

    private val stateHistory = HistoryValue<Any?>(null) //State logic ignores T

    private val switchLock = Object()

    private fun setStateImpl(state: Any, waitable: TickedWaitable) {
        if (!registered) {
            waitable.tick()
            return //Do now allow any state transitions if the state machine is not registered
        }
        if (state != activeState?.name) { //If the state requested is different from the current state
            val desiredState = if (states.any { it.name == state }) { //If the list contains the desired state
                states.last { it.name == state } //Make it the desired state
            }
            else {
                elseCondition //Otherwise we use the "else" condition
            }

            if (!desiredState.rejectionConditions() && !isGloballyRejected(desiredState)) { //If the switch is not rejected
                //STOP THE OLD STATE TIMEOUT
                activeTimeoutHandle?.stopTask(true)

                //EXIT THE OLD STATE
                if (activeState != null) {
                    activeActionManager?.stopAction() //Cancel the action loop
                    activeActionManager?.awaitDone() //Wait for the action to be done

                    //Run the exit method and wait
                    activeState?.exit?.run()
                }

                //UPDATE THE STORED STATE
                activeState = desiredState //Update the active state to the new state
                stateHistory.update(state) //Update the state history to the new state

                //ENTER THE NEW STATE
                desiredState.entry.run()
                waitable.tick()

                //RUN THE LOOP OF THE NEW STATE
                activeActionManager = desiredState.actionManager
                activeActionManager?.startAction()

                //SET UP THE TIMEOUT OF THE NEW STATE
                if (desiredState.timeout.value != -1.0) {
                    activeTimeoutHandle = executor.scheduleSingleTask(ExceptionHandlingRunnable {
                        setStateInternal(desiredState.timeoutTo)
                    }, desiredState.timeout)
                }
            } else { //The switch was rejected
                waitable.tick()
            }
        } else { //There is no need to switch
            waitable.tick()
        }
    }

    internal fun setStateInternal(state: Any): IWaitable {
        val waitable = TickedWaitable()
        executor.scheduleSingleTaskNow(ExceptionHandlingRunnable {
            synchronized(switchLock) {
                setStateImpl(state, waitable)
            }
        })
        return waitable
    }

    internal fun register() {
        registered = true
        states.forEach {
            it.actionManager.register()
        }
    }

    /**
     * Sets the state of this machine to the given state.
     * If the machine is already in the given state, no action is taken.
     * @param state The state to switch to
     * @return A waitable object that unblocks when the state's "entry" finishes
     */
    fun setState(state: T): IWaitable {
        return setStateInternal(state as Any) //Downcast to Any here, state logic ignores T
    }

    /**
     * Returns the state machine to the state it was in previously
     */
    fun back() = setStateInternal(getLastState())

    /**
     * Sets the state machine to the built in "disabled" state
     */
    fun disable() = setStateInternal(States.DISABLED)

    /**
     * Gets the state that the machine is currently in
     * Note that this value is not updated during a state change until the "exit" method of the previous state finishes
     * @return The state that the machine is currently in
     */
    fun getState() = stateHistory.current ?: States.ELSE

    /**
     * Gets the state that the machine was in last
     * Note that this value is not updated during a state change until the "exit" method of the previous state finishes
     * @return The state that the machine was last in
     */
    fun getLastState() = stateHistory.last ?: States.ELSE

    /**
     * Checks if a machine is in the given state
     * @param state The state to check
     * @return true if the machine is in this state, false otherwise
     */
    fun isInState(state: T) = stateHistory.current == state

    /**
     * Checks if a machine was in the given state
     * @param state The state to check
     * @return true if the machine is in this state, false otherwise
     */
    fun wasInState(state: T) = stateHistory.last == state

    /**
     * Toggles between two states.
     * The logic is as follows:
     * If the machine is in state1, switch to state2.  Otherwise, switch to state1
     * This means that if the machine is in any other state than state1, it will switch to state1.
     * @param state1 State 1 to toggle
     * @param state2 State 2 to toggle
     * @return The waitable of whatever state was switched to
     */
    fun toggle(state1: T, state2: T): IWaitable {
        return if (getState() == state1) {
            setState(state2)
        } else {
            setState(state1)
        }
    }
}