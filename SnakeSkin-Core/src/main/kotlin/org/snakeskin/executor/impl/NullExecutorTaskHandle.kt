package org.snakeskin.executor.impl

import org.snakeskin.executor.IExecutorTaskHandle

/**
 * Empty executor task handle for when a task has not been scheduled
 */
object NullExecutorTaskHandle: IExecutorTaskHandle {
    override fun stopTask(interrupt: Boolean) {}
    override fun waitFor() {}
}