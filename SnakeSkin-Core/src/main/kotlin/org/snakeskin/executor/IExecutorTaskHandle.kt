package org.snakeskin.executor

import org.snakeskin.ability.AWaitable

/**
 * Handle for an executor task.  Allows the task to be stopped in the future
 */
interface IExecutorTaskHandle: AWaitable {
    fun stopTask(interrupt: Boolean = false)
}