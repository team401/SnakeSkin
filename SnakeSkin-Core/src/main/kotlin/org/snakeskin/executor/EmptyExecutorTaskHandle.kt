package org.snakeskin.executor

/**
 * Empty executor task handle for when a task has not been scheduled
 */
object EmptyExecutorTaskHandle: IExecutorTaskHandle {
    override fun stopTask(interrupt: Boolean) {}
    override fun waitFor() {}
}