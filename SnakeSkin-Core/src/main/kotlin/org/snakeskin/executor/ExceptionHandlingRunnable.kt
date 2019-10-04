package org.snakeskin.executor

import org.snakeskin.logging.LoggerManager

/**
 * @author Cameron Earle
 * @version 5/16/18
 */
class ExceptionHandlingRunnable(private val lambda: () -> Unit): Runnable {
    companion object {
        /**
         * An empty ExceptionHandlingRunnable that can be used to check with reference equality
         * to avoid scheduling empty tasks on the executor
         */
        val EMPTY = ExceptionHandlingRunnable {}
    }

    override fun run() {
        try {
            lambda()
        } catch (e: Exception) {
            LoggerManager.logThrowable(e)
        }
    }
}