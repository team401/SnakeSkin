package org.team401.snakeskin.subsystem

import org.team401.snakeskin.component.Component
import org.team401.snakeskin.logic.Parameters
import org.team401.snakeskin.event.EventRouter
import java.util.concurrent.*
import java.util.concurrent.atomic.AtomicReference
import java.util.concurrent.locks.ReentrantLock

/*
 * SnakeSkin - Created on 7/4/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 7/4/17
 */

class Subsystem {
    val MODIFIER = Modifier()

    private val executor = ScheduledThreadPoolExecutor(1) //This subsystem's executor.  All subsystem tasks should be run on this
    private var setupTasks = {} //The tasks to run to set up the subsystem (non-lib init for example, as all lib tasks are auto init by the init registry)

    private val states = hashMapOf<String, () -> Unit>() //The states that a subsystem can be in
    private var activeState: String = ""
    private var activeStateFuture: Future<*>? = null //The future for the active state (for cancellation)
    private val stateLock = ReentrantLock()

    private var mode = AtomicReference("") //An atomic mode, which can be used by custom subsystem state machines

    fun setMode(newMode: String) = mode.set(newMode)
    fun getMode() = mode.get()

    fun setState(state: String) {
        if (states.containsKey(state)) {
            val action = {
                stateLock.lock()
                activeStateFuture?.cancel(true) //Cancel the active task
                activeStateFuture = executor.submit { states[state]!!.invoke() } //Submit the new task
                activeState = state
                stateLock.unlock()
            }
            if (stateLock.isLocked) { //If a state change is in process, dump the switch into another thread
                Thread { action() }.start()
            } else {
                action()
            }
        }
    }

    fun getState() = activeState

    inner class Modifier {
        val subsystem = this@Subsystem //Same as build, but provides a less "final" looking interface

        /**
         * Method called by the Subsystem Registry when it is time to setup this subsystem
         * This method will be called every time the robot is staging to enable
         */
        fun init() {
            executor.prestartAllCoreThreads()
            executor.submit(setupTasks) //Run the setup tasks
        }

        /**
         * Registers a loop to be run on the subsystem executor.
         */
        fun registerLoop(rate: Long, action: () -> Unit) {
            executor.scheduleAtFixedRate(action, 0, rate, TimeUnit.MILLISECONDS)
        }

        /**
         * Registers an event handler, which reacts to a global event fired by the event router
         */
        fun registerEventHandler(event: String, action: (Parameters) -> Unit) {
            EventRouter.registerPriority(event) { //Register a priority handler
                executor.submit { //Run the task in our executor
                    action(it) //Run the action with the event from the router
                }
            }
        }

        /**
         * Sets the setup tasks that will be run on robot startup
         */
        fun registerSetupTasks(action: () -> Unit) {
            setupTasks = action
        }

        fun registerState(state: String, action: () -> Unit) = states.put(state, action)

        fun setStateInternally(state: String) {
            if (states.containsKey(state)) {
                stateLock.lock() //Grab the state lock so outside systems will have to wait to change states
                activeStateFuture?.cancel(true) //Cancel any outside attempts to switch state
                activeStateFuture = null
                states[state]!!.invoke() //We already know this is inside an executor thread, so no need to submit
                activeState = state
                stateLock.unlock()
            }
        }
    }


}