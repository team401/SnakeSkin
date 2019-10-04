package org.snakeskin.logging

import java.io.File
import java.io.PrintWriter
import java.io.StringWriter
import java.util.*

/**
 * @author Cameron Earle
 * @version 8/26/17
 */

object LoggerManager {
    private const val MAX_LOG_FILES = 10

    private val HOME_DIR = System.getProperty("user.home")

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

SnakeSkin encountered a crash it couldn't recover from.

Timestamp: $date

Full stack trace below:
""")
        pw.println()
        t.printStackTrace(pw)

        return sw.toString()
    }

    private fun deleteFiles(folder: File) {
        if (folder.isDirectory) {
            var files = folder.listFiles() ?: return
            files.sortBy {
                it.lastModified()
            }

            while (files.size >= MAX_LOG_FILES) {
                files[0]?.delete()

                files = folder.listFiles() ?: return
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

    private val exceptionHandler = Thread.UncaughtExceptionHandler { t, e ->
        logThrowable(e, t)
    }

    private val mainThreadExceptionHandler = Thread.UncaughtExceptionHandler { t, e ->
        logCrash(e, t)
    }

    @JvmStatic fun logCurrentThread() {
        Thread.currentThread().uncaughtExceptionHandler = exceptionHandler
    }

    @JvmStatic fun logMainThread() {
        Thread.currentThread().uncaughtExceptionHandler = mainThreadExceptionHandler
    }
}