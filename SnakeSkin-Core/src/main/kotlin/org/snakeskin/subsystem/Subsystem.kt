package org.snakeskin.subsystem

import org.snakeskin.logic.Parameters
import org.snakeskin.event.EventRouter
import org.snakeskin.event.Events
import org.snakeskin.exception.InitException
import org.snakeskin.exception.ItemNotFoundException
import org.snakeskin.factory.ExecutorFactory
import org.snakeskin.state.StateMachine
import java.lang.reflect.InvocationTargetException

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

open class Subsystem(val name: String = "UNNAMED") {
    //Executor, for running subsystem actions
    private val executor = ExecutorFactory.getExecutor("Subsystem")

    //<editor-fold desc="State Handler">
    private val stateMachines = hashMapOf<String, StateMachine>() //The states that a subsystem can be in

    fun addStateMachine(machine: String, instance: StateMachine = StateMachine()) = stateMachines.put(machine, instance)

    fun getStateMachine(machine: String): StateMachine {
        if (stateMachines.contains(machine)) {
            return stateMachines[machine]!!
        } else {
            throw ItemNotFoundException("Could not find state machine $machine")
        }
    }

    fun getDefaultStateMachine(): StateMachine {
        val firstKey = stateMachines.keys.firstOrNull()
        if (firstKey != null) {
            return stateMachines[firstKey]!!
        } else {
            throw ItemNotFoundException("Subsystem doesn't have any state machines")
        }
    }


    //</editor-fold>

    //<editor-fold desc="Setup Tasks">
    private val setupTasks = arrayListOf<() -> Unit>()
    fun addSetupTask(task: () -> Unit) = setupTasks.add(task)
    //</editor-fold>

    //<editor-fold desk="Tests">
    private val tests = hashMapOf<String, () -> Boolean>()
    fun addTest(name: String, test: () -> Boolean) = tests.put(name, test)
    fun runTests() {
        tests.forEach {
            name, test ->
            println("TEST $name\tSTARTING")
            val result = test()
            if (result)
                println("TEST $name\tPASSED")
            else
                println("TEST $name\tFAILED")
        }
    }
    //</editor-fold>

    internal fun init() {
        setupTasks.forEach {
            try {
                it()
            } catch (e: Exception) {
                throw InitException("Error occurred while running setup tasks for subsystem '$name'", e)
            }
        }
        stateMachines.forEach {
            _, machine ->
            EventRouter.registerPriority(Events.DISABLED) {
                machine.setState(States.DISABLED)
            }
        }
    }

    fun addEventHandler(event: String, action: (Parameters) -> Unit) = EventRouter.registerPriority(event) {
        executor.submit {
            action(it)
        }
    }
}