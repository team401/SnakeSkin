package org.snakeskin.state

import org.snakeskin.ability.AWaitable
import org.snakeskin.factory.ExecutorFactory
import org.snakeskin.logic.History
import org.snakeskin.logic.NullWaitable
import org.snakeskin.logic.TickedWaitable
import org.snakeskin.logic.WaitableFuture
import org.snakeskin.publish.Publisher
import org.snakeskin.subsystem.States
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
    private val SCHEDULER = ExecutorFactory.getSingleExecutor("State Machine Scheduler")

    private val states = arrayListOf<State>()
    fun addState(state: State) = states.add(state)

    var elseCondition = State(States.ELSE, {}, {}, {})

    private var activeState: State? = null
    private var activeFuture: ScheduledFuture<*>? = null
    private var activeTimeoutFuture: ScheduledFuture<*>? = null

    private val stateHistory = History<String>()

    private val switchLock = ReentrantLock()

    val publisher = Publisher()

    private fun setStateImpl(state: String): AWaitable {
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
                    EXECUTOR.submit {
                        activeState?.exit?.invoke() //Run the exit method
                    }.get() //And wait
                }

                //UPDATE THE STORED STATE
                activeState = desiredState //Update the active state to the new state
                stateHistory.update(state) //Update the state history to the new state

                //ENTER THE NEW STATE
                EXECUTOR.submit {
                    desiredState.entry() //Run the entry method of the desired state
                    toReturn.tick() //Tick the waitable
                }.get() //And wait

                //RUN THE LOOP OF THE NEW STATE
                if (desiredState.action != {}) { //If the target state has an action
                    if (publisher.populated()) { //If the publisher has tasks
                        activeFuture = EXECUTOR.scheduleAtFixedRate({desiredState.action; publisher.publish()}, 0, desiredState.rate, TimeUnit.MILLISECONDS)
                    } else { //The publisher has no tasks
                        activeFuture = EXECUTOR.scheduleAtFixedRate(desiredState.action, 0, desiredState.rate, TimeUnit.MILLISECONDS)
                    }
                } else { //Otherwise, just schedule the publisher
                    if (publisher.populated()) { //If it has tasks
                        activeFuture = EXECUTOR.scheduleAtFixedRate({ publisher.publish() }, 0, desiredState.rate, TimeUnit.MILLISECONDS)
                    }
                }

                //SET UP THE TIMEOUT OF THE NEW STATE
                if (desiredState.timeout != -1L) {
                    activeTimeoutFuture = EXECUTOR.schedule({
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

    fun setState(state: String): AWaitable {
        val waitable = WaitableFuture()
        SCHEDULER.submit {
            switchLock.lock()
            waitable.initWaitable(setStateImpl(state))
            switchLock.unlock()
        }
        return waitable
    }

    @Deprecated("All state switches should now be run on the scheduler", ReplaceWith("setState(state: String)"))
    internal fun setStateInternally(state: String) {
        switchLock.lock()
        setStateImpl(state)
        switchLock.unlock()
    }

    fun back() = setState(getLastState())

    fun getState() = stateHistory.current ?: States.ELSE
    fun getLastState() = stateHistory.last ?: States.ELSE

    fun toggle(state1: String, state2: String) {
        if (getState() == state1) {
            setState(state2)
        } else {
            setState(state1)
        }
    }

}