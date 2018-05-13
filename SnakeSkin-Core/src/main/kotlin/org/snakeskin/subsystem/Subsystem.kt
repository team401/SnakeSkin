package org.snakeskin.subsystem

import org.snakeskin.logic.Parameters
import org.snakeskin.event.EventRouter
import org.snakeskin.event.Events
import org.snakeskin.exception.InitException
import org.snakeskin.exception.ItemNotFoundException
import org.snakeskin.factory.ExecutorFactory
import org.snakeskin.state.StateMachine
import java.lang.reflect.InvocationTargetException
import java.util.concurrent.TimeUnit

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

open class Subsystem(val name: String, private val loopRate: Long = 20L) {
    //Executor, for running subsystem actions
    private val executor = ExecutorFactory.getExecutor("Subsystem")

    private val stateMachines = arrayListOf<StateMachine>()
    fun addStateMachine(machine: StateMachine = StateMachine()) = stateMachines.add(machine)

    /**
     * Setup tasks for this subsystem
     */
    open fun setup() {}

    /**
     * Looping actions for this subsystem
     */
    open fun action() {}

    internal fun init() {
        try {
            setup()
        } catch (e: Exception) {
            throw InitException("Error occured while running setup tasks for subsystem '$name", e)
        }
        stateMachines.forEach {
            machine ->
            EventRouter.registerHandler(Events.DISABLED) {
                machine.setState(States.DISABLED)
            }
        }
        executor.scheduleAtFixedRate(this::action, 0L, loopRate, TimeUnit.MILLISECONDS)
    }
}