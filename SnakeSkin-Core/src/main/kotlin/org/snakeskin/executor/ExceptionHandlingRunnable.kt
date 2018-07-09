package org.snakeskin.executor

import org.snakeskin.logging.LoggerManager

/**
 * @author Cameron Earle
 * @version 5/16/18
 */
class ExceptionHandlingRunnable(private val r: Runnable?): Runnable {
    override fun run() {
        try {
            r?.run()
        } catch (e: Exception) {
            LoggerManager.logThrowable(e)
        }
    }
}