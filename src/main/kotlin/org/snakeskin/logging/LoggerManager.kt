package org.snakeskin.logging

import com.google.gson.Gson
import org.snakeskin.Constants
import org.snakeskin.ability.ASerializable
import org.snakeskin.factory.ExecutorFactory
import java.util.*
import java.util.concurrent.TimeUnit

/*
 * snakeskin - Created on 8/26/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 8/26/17
 */

object LoggerManager {
    private val EXECUTOR = ExecutorFactory.getSingleExecutor("Logger")

    private val gson = Gson()

    internal fun init() {

    }

    @JvmStatic @JvmOverloads fun logThrowable(e: Throwable, t: Thread? = null) {
        e.printStackTrace()
    }

    @JvmStatic @JvmOverloads fun logCrash(e: Throwable, t: Thread? = null) {
        e.printStackTrace()
        //TODO add crash file
    }

    @JvmStatic @JvmOverloads fun logMessage(message: String, level: LogLevel = LogLevel.INFO) {
        println(message)
    }

    fun getExceptionHandler() = Thread.UncaughtExceptionHandler { t, e ->
        logThrowable(e, t)
    }

    fun getMainThreadExceptionHandler() = Thread.UncaughtExceptionHandler { t, e ->
        logCrash(e, t)
    }

    @JvmStatic fun logCurrentThread() {
        Thread.currentThread().uncaughtExceptionHandler = getExceptionHandler()
    }

    @JvmStatic fun logMainThread() {
        Thread.currentThread().uncaughtExceptionHandler = getMainThreadExceptionHandler()
    }
}