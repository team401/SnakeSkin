package org.snakeskin.state

import org.snakeskin.ability.AWaitable
import org.snakeskin.factory.ExecutorFactory
import org.snakeskin.logic.History
import org.snakeskin.logic.NullWaitable
import org.snakeskin.logic.TickedWaitable
import org.snakeskin.logic.WaitableFuture
import org.snakeskin.subsystem.States
import java.util.concurrent.Future
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.ReentrantLock

/**
 * @author Cameron Earle
 * @version 8/3/17
 */
class StateMachine {
    companion object {
        /**
         * An shared reference to an empty lambda, which can be used as a default value to avoid running empty
         * tasks on the executor.  Checks should be made using the "===" in Kotlin to check reference equality
         */
        val EMPTY_LAMBDA = {}
    }
    private val executor = ExecutorFactory.getExecutor("State Machine")
    private val scheduler = ExecutorFactory.getSingleExecutor("State Machine Scheduler")

    private val states = arrayListOf<State>()

    /**
     * Adds a state to this state machine
     * @param state The state to add
     */
    fun addState(state: State) = states.add(state)

    /**
     * The state to go to when a state change is requested for a state that doesn't exist
     */
    var elseCondition = State(States.ELSE, EMPTY_LAMBDA, EMPTY_LAMBDA, EMPTY_LAMBDA)

    private var activeState: State? = null
    private var activeFuture: Future<*>? = null //Represents whatever task the state machine is currently running
    private var activeTimeoutFuture: ScheduledFuture<*>? = null //Represents the timeout that the state machine is currently running

    private val stateHistory = History<Any>()

    private val switchLock = ReentrantLock()

    private fun setStateImpl(state: Any): AWaitable {
        val toReturn = TickedWaitable() //The waitable element.  It will tick once "entry" has completed
        if (state != activeState?.name) { //If the state requested is different from the current state
            val desiredState = if (states.any { it.name == state }) { //If the list contains the desired state
                states.last { it.name == state } //Make it the desired state
            }
            else {
                elseCondition //Otherwise we use the "else" condition
            }

            if (!desiredState.rejectionConditions()) { //If the switch is not rejected
                //STOP THE OLD STATE TIMEOUT
                activeTimeoutFuture?.cancel(true)

                //EXIT THE OLD STATE
                if (activeState != null) {
                    activeFuture?.cancel(true) //Cancel the action loop
                    activeFuture = executor.submit {
                        activeState?.exit?.invoke() //Run the exit method
                    }
                    activeFuture?.get() //And wait
                }

                //UPDATE THE STORED STATE
                activeState = desiredState //Update the active state to the new state
                stateHistory.update(state) //Update the state history to the new state

                //ENTER THE NEW STATE
                activeFuture = executor.submit {
                    desiredState.entry() //Run the entry method of the desired state
                    toReturn.tick() //Tick the waitable
                }
                activeFuture?.get() //And wait

                //RUN THE LOOP OF THE NEW STATE
                if (desiredState.action !== EMPTY_LAMBDA) { //If the target state has an action
                    activeFuture = executor.scheduleAtFixedRate(desiredState.action, 0, desiredState.rate, TimeUnit.MILLISECONDS)
                }

                //SET UP THE TIMEOUT OF THE NEW STATE
                if (desiredState.timeout != -1L) {
                    activeTimeoutFuture = executor.schedule({
                        setState(desiredState.timeoutTo)
                    }, desiredState.timeout, TimeUnit.MILLISECONDS)
                }

                return toReturn //Return the waitable
            } else { //The switch was rejected
                return NullWaitable() //Return a null waitable
            }
        } else { //There is no need to switch
            return NullWaitable() //Return a null waitable
        }
    }

    /**
     * Sets the state of this machine to the given state.
     * If the machine is already in the given state, no action is taken.
     * @param state The state to switch to
     * @return A waitable object that unblocks when the state's "entry" finishes
     */
    fun setState(state: Any): AWaitable {
        val waitable = WaitableFuture()
        scheduler.submit {
            switchLock.lock()
            waitable.initWaitable(setStateImpl(state))
            switchLock.unlock()
        }
        return waitable
    }

    /**
     * Returns the state machine to the state it was in previously
     */
    fun back() = setState(getLastState())

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
    fun isInState(state: Any) = stateHistory.current == state

    /**
     * Checks if a machine was in the given state
     * @param state The state to check
     * @return true if the machine is in this state, false otherwise
     */
    fun wasInState(state: Any) = stateHistory.last == state

    /**
     * Toggles between two states.
     * The logic is as follows:
     * If the machine is in state1, switch to state2.  Otherwise, switch to state1
     * This means that if the machine is in any other state than state1, it will switch to state1.
     * @param state1 State 1 to toggle
     * @param state2 State 2 to toggle
     * @return The waitable of whatever state was switched to
     */
    fun toggle(state1: Any, state2: Any): AWaitable {
        return if (getState() == state1) {
            setState(state2)
        } else {
            setState(state1)
        }
    }

}