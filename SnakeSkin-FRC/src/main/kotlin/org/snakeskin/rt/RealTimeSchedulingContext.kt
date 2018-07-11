package org.snakeskin.rt

import org.snakeskin.executor.SchedulingContext
import java.util.concurrent.ScheduledFuture

/**
 * @author Cameron Earle
 * @version 7/10/2018
 *
 */
class RealTimeSchedulingContext(val task: RealTimeTask): SchedulingContext {
    override fun schedule(): ScheduledFuture<*> {
        return RealTimeExecutor.addTask(task)
    }
}