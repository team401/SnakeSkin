package org.snakeskin.subsystem

import org.snakeskin.event.EventRouter
import org.snakeskin.event.Events
import org.snakeskin.exception.InitException
import org.snakeskin.executor.ExceptionHandlingRunnable
import org.snakeskin.executor.IExecutorTaskHandle
import org.snakeskin.measure.time.TimeMeasureSeconds
import org.snakeskin.runtime.SnakeskinRuntime
import org.snakeskin.state.StateMachine
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

/**
 * @author Cameron Earle
 * @version 7/4/17
 */
open class Subsystem(private val loopRate: TimeMeasureSeconds = TimeMeasureSeconds(0.02)) {
    val name: String = this.javaClass.simpleName //Use reflection to get the name of the implementing class

    //Executor, for running subsystem actions
    private val executor = SnakeskinRuntime.primaryExecutor
    private var loopTaskHandle: IExecutorTaskHandle? = null
    private val stateMachines = arrayListOf<StateMachine<*>>()

    /**
     * Adds a state machine to this subsystem
     * @param machine The state machine to add
     */
    fun addStateMachine(machine: StateMachine<*>) = stateMachines.add(machine)

    private val faults = hashSetOf<Any>()
    /**
     * Registers the specified fault to this subsystem
     * @param fault The fault to add
     */
    @Synchronized fun fault(fault: Any) = faults.add(fault)

    /**
     * Removes a fault from this subsystem
     * @param fault The fault to remove
     */
    @Synchronized fun clearFault(fault: Any) = faults.remove(fault)

    /**
     * Returns true if this subsystem has any faults
     * @return true if this subsystem has any faults, false otherwise
     */
    @Synchronized fun isFaulted() = faults.isNotEmpty()

    /**
     * Returns true if this subsystem has any of the provided faults
     * @param faults The faults to check
     * @return true if this subsystem has any of the provided faults, false otherwise
     */
    @Synchronized fun isFaulted(vararg faults: Any) = faults.any { this.faults.contains(it) }

    /**
     * Setup tasks for this subsystem
     */
    open fun setup() {}

    /**
     * Check tasks for this subsystem
     */
    open fun check(ctx: SubsystemCheckContext) {}

    /**
     * Performs subsystem checks
     */
    fun checkSubsystem() {
        println("Beginning checks for subsystem $name")
        val ctx = SubsystemCheckContext(
                {
                    check ->
                    println("S[$name]\tC[$check]\tPASSED")
                },
                {
                    check, reason ->
                    println("S[$name]\tC[$check]\tFAILED\t-\t$reason")
                }
        )
        check(ctx)
        println("Checks done for subsystem $name")
    }

    /**
     * Looping actions for this subsystem
     */
    open fun action() {
        loopTaskHandle?.stopTask(false) //Cancel the loopable task since there isn't one (default)
    }

    internal fun init() {
        try {
            setup()
        } catch (e: Exception) {
            throw InitException("Exception while running setup tasks for subsystem '$name'", e)
        }
        stateMachines.forEach {
            machine ->
            machine.register()
            EventRouter.registerHandler(Events.DISABLED, ExceptionHandlingRunnable {
                machine.disable()
            })
        }
        loopTaskHandle = executor.schedulePeriodicTask(ExceptionHandlingRunnable(::action), loopRate)
    }
}