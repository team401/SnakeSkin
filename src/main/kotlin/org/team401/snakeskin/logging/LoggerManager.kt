package org.team401.snakeskin.logging

import com.google.gson.Gson
import org.team401.snakeskin.Constants
import org.team401.snakeskin.ability.ASerializable
import org.team401.snakeskin.factory.ExecutorFactory
import org.zeromq.ZMQ
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

    private val context = ZMQ.context(1)
    private lateinit var socket: ZMQ.Socket
    private val gson = Gson()

    private val valueQueue = Vector<LoggableValue>()

    private fun send(message: ASerializable) {
        EXECUTOR.submit {
            socket.send(message.serialize(gson))
        }
    }

    internal fun init() {
        EXECUTOR.submit {
            socket = context.socket(ZMQ.PUB)
            socket.bind("tcp://*:5800")
        }.get()

        EXECUTOR.scheduleAtFixedRate({ //Schedule the task to poll values
            valueQueue.forEach {
                val valueObj = object : LoggableValue(it.name, it.getter) {
                    val value = getter()
                }

                send(valueObj)
            }
        }, 0L, Constants.LOG_RATE, TimeUnit.MILLISECONDS)
    }

    @JvmStatic @JvmOverloads fun logThrowable(e: Throwable, t: Thread? = null) {
        send(LoggableThrowable(e, t))
    }

    @JvmStatic @JvmOverloads fun logMessage(message: String, level: LogLevel = LogLevel.INFO) {
        send(LoggableMessage(message, level))
    }

    fun addValue(name: String, getter: () -> Any) {
        valueQueue.add(LoggableValue(name, getter))
    }

    fun getExceptionHandler() = Thread.UncaughtExceptionHandler { t, e ->
        logThrowable(e, t)
    }

    @JvmStatic fun logCurrentThread() {
        Thread.currentThread().uncaughtExceptionHandler = getExceptionHandler()
    }
}