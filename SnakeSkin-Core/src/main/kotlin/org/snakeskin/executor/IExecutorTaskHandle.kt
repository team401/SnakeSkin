package org.snakeskin.executor

import org.snakeskin.ability.IWaitable

/**
 * Handle for an executor task.  Allows the task to be stopped in the future
 */
interface IExecutorTaskHandle: IWaitable {
    fun stopTask(interrupt: Boolean = false)
}