package org.snakeskin.dsl

import org.snakeskin.rt.RealTimeExecutor
import org.snakeskin.rt.RealTimeSchedulingContext
import org.snakeskin.rt.RealTimeTask

/**
 * @author Cameron Earle
 * @version 7/10/2018
 *
 */

/**
 * Creates an action loop for a state machine that should run on the Real Time executor
 * The rate of this task is determined by the global rate of that executor.
 */
fun StateBuilder<*>.rtAction(action: RealTimeExecutor.RealTimeContext.() -> Unit) {
    builder.action = { action(RealTimeExecutor.RealTimeContext()) }
    builder.schedulingContext = RealTimeSchedulingContext(object : RealTimeTask {
        override val name = "StateMachineRtAction"
        override fun action(ctx: RealTimeExecutor.RealTimeContext) {
            action(ctx)
        }
    })
}