package org.team401.snakeskin.subsystem

import org.team401.snakeskin.component.Component
import org.team401.snakeskin.logic.Parameters
import org.team401.snakeskin.event.EventRouter
import org.team401.snakeskin.event.Events
import org.team401.snakeskin.factory.ExecutorFactory
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
    //Executor, for running subsystem actions
    private val executor = ExecutorFactory.getExecutor("Subsystem")

    //<editor-fold desc="State Handler">
    var STATE = "" //The active state a subsystem is in
    @Synchronized get set(value) {
        field = value
        setState(value)
    }
    private val states = hashMapOf<String, () -> Unit>() //The states that a subsystem can be in
    private var activeStateFuture: Future<*>? = null //The future for the active state (for cancellation)
    private val stateLock = ReentrantLock()

    private fun setState(state: String, internal: Boolean = false) {
        if (states.containsKey(state)) {
            val action = {
                stateLock.lock()
                activeStateFuture?.cancel(true) //Cancel the active task
                if (internal) {
                    states[state]!!.invoke()
                } else {
                    activeStateFuture = executor.submit { states[state]!!.invoke() }
                }
                stateLock.unlock()
            }
            if (stateLock.isLocked) { //If a state change is in process, dump the switch into another thread
                Thread { action() }.start()
            } else {
                action()
            }
        }
    }
    internal fun setStateInternally(state: String) = setState(state, internal = true)

    fun addState(state: String, action: () -> Unit) = states.put(state, action)

    //</editor-fold>

    //<editor-fold desc="Setup Tasks">
    private val setupTasks = arrayListOf<() -> Unit>()
    fun addSetupTask(task: () -> Unit) = setupTasks.add(task)
    //</editor-fold>

    private val internalMode = AtomicReference<String>("")
    var MODE
    get() = internalMode.get()
    set(value) {
        internalMode.set(value)
    }

    internal fun init() {
        setupTasks.forEach {
            executor.submit(it)
        }
        EventRouter.registerPriority(Events.DISABLED) {
            MODE = Modes.DISABLED
        }
    }

    fun addLoop(rate: Long, action: () -> Unit) = executor.scheduleAtFixedRate(action, 0, rate, TimeUnit.MILLISECONDS)

    fun addEventHandler(event: String, action: (Parameters) -> Unit) = EventRouter.registerPriority(event) {
        executor.submit {
            action(it)
        }
    }
}