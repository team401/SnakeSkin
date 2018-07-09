package org.snakeskin.logging

import com.google.gson.Gson
import org.snakeskin.SnakeskinConstants
import org.snakeskin.factory.ExecutorFactory
import java.io.File
import java.io.PrintWriter
import java.io.StringWriter
import java.util.*

/**
 * @author Cameron Earle
 * @version 8/26/17
 */

object LoggerManager {
    private val HOME_DIR = System.getProperty("user.home")

    private val EXECUTOR = ExecutorFactory.getSingleExecutor("Logger")

    private val gson = Gson()

    private fun crashMessage(date: Date, t: Throwable): String {
        val sw = StringWriter()
        val pw = PrintWriter(sw)
        sw.append(
"""
███████╗███╗   ██╗ █████╗ ██╗  ██╗███████╗███████╗██╗  ██╗██╗███╗   ██╗        ██╗
██╔════╝████╗  ██║██╔══██╗██║ ██╔╝██╔════╝██╔════╝██║ ██╔╝██║████╗  ██║    ██╗██╔╝
███████╗██╔██╗ ██║███████║█████╔╝ █████╗  ███████╗█████╔╝ ██║██╔██╗ ██║    ╚═╝██║
╚════██║██║╚██╗██║██╔══██║██╔═██╗ ██╔══╝  ╚════██║██╔═██╗ ██║██║╚██╗██║    ██╗██║
███████║██║ ╚████║██║  ██║██║  ██╗███████╗███████║██║  ██╗██║██║ ╚████║    ╚═╝╚██╗
╚══════╝╚═╝  ╚═══╝╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝╚══════╝╚═╝  ╚═╝╚═╝╚═╝  ╚═══╝        ╚═╝

SnakeSkin encountered such a spicy meme that it couldn't recover.

Timestamp: $date

Full stack trace below:
""")
        pw.println()
        t.printStackTrace(pw)

        return sw.toString()
    }

    private fun deleteFiles(folder: File) {
        if (folder.isDirectory) {
            var files = folder.listFiles()
            files.sortBy {
                it.lastModified()
            }

            while (files.size >= SnakeskinConstants.MAX_LOG_FILES) {
                files[0]?.delete()

                files = folder.listFiles()
                files.sortBy {
                    it.lastModified()
                }
            }
        }
    }

    @JvmStatic internal fun init() {

    }

    @JvmStatic @JvmOverloads fun logThrowable(e: Throwable, t: Thread? = null) {
        e.printStackTrace()
    }

    @JvmStatic @JvmOverloads fun logCrash(e: Throwable, t: Thread? = null) {
        val date = Date(System.currentTimeMillis())

        e.printStackTrace()

        val folder = File("$HOME_DIR/snakeskin_crashes")

        if (!folder.exists()) {
            folder.mkdir()
        }

        deleteFiles(folder) //Delete old log files

        val filename = date.toString().replace(' ', '_').replace(':', '-') + ".txt"

        val file = File("$HOME_DIR/snakeskin_crashes/$filename")
        file.writeText(crashMessage(date, e))

        println("Crash report written to '${file.absolutePath}'")
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