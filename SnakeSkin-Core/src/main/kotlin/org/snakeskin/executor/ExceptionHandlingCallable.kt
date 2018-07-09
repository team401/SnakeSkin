package org.snakeskin.executor

import org.snakeskin.logging.LoggerManager
import java.util.concurrent.Callable

/**
 * @author Cameron Earle
 * @version 5/16/18
 */
class ExceptionHandlingCallable<T>(private val c: Callable<T>?): Callable<T> {
    override fun call(): T? {
        try {
            return c?.call()
        } catch (e: Exception) {
            LoggerManager.logThrowable(e)
        }
        return null
    }
}