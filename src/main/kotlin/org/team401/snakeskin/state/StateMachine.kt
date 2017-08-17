package org.team401.snakeskin.state

import org.team401.snakeskin.ability.AWaitable
import org.team401.snakeskin.factory.ExecutorFactory
import org.team401.snakeskin.logic.History
import org.team401.snakeskin.logic.NullWaitable
import org.team401.snakeskin.logic.TickedWaitable
import java.util.concurrent.Future
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.ReentrantLock

/*
 * snakeskin - Created on 8/3/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 8/3/17
 */

class StateMachine {
    private val EXECUTOR = ExecutorFactory.getExecutor("State Machine")
    private val SCHEDULER = ExecutorFactory.getSchedulerExecutor("State Machine Scheduler")

    private val states = arrayListOf<State>()
    fun addState(state: State) = states.add(state)

    private var activeState: State? = null
    private var activeFuture: ScheduledFuture<*>? = null

    private val stateHistory = History<String>()

    private val switchLock = ReentrantLock()


    private fun setState(state: String, internal: Boolean): AWaitable {
        val toReturn = TickedWaitable() //The waitable element.  It will tick once "entry" has completed
        if (states.any { it.name == state }) { //If the state machine contains the desired state
            val desiredState = states.first { it.name == state } //Grab the desired state from the list
            val task = { //A lambda that holds the general task.  It will either be called inside or outside of the scheduler
                if (!desiredState.rejectionConditions()) { //If the desired state change is not rejected
                    stateHistory.update(state) //Update the state now so external listeners can be aware of the change
                    if (activeState != null) { //If there is an active state
                        activeFuture?.cancel(true) //Cancel the action loop of the active state
                        EXECUTOR.submit {
                            activeState?.exit?.invoke() //Run the exit method of the active state
                        }.get() //And wait
                    }
                    EXECUTOR.submit {
                        desiredState.entry() //Run the entry method of the desired state
                        toReturn.tick() //Tick the waitable
                    }.get() //And wait
                    if (desiredState.action != {}) { //If the action loop exists
                        activeFuture = EXECUTOR.scheduleAtFixedRate(desiredState.action, 0, desiredState.rate, TimeUnit.MILLISECONDS) //Run the action loop
                    }
                }
            }
            //Now, we'll actually run the task
            if (internal) { //If it's internal, we don't want to use the scheduler, as if they did a state switch within
                            //the current switch, it would result in deadlock on the scheduler.
                switchLock.lock()
                task()
                switchLock.unlock()
            } else { //If it's not internal, we want to run it in the scheduler, so it doesn't hold up the caller
                SCHEDULER.submit {
                    switchLock.lock()
                    task()
                    switchLock.unlock()
                }
            }
            return toReturn //Return the waitable
        }
        return NullWaitable() //If the state doesn't exist, return a null waitable to prevent caller from waiting
    }

    fun setState(state: String) = setState(state, false)

    fun getState() = stateHistory.current ?: ""
    fun getLastState() = stateHistory.current ?: ""

    fun toggle(state1: String, state2: String) {
        if (getState() == state1) {
            setState(state2)
        } else {
            setState(state1)
        }
    }

}