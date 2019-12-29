package org.snakeskin.logging

import org.snakeskin.ability.ILoggable

/**
 * @author Cameron Earle
 * @version 8/26/17
 */
class LoggableThrowable(e: Throwable, t: Thread?): ILoggable {
    override val type = "exception"

    val name = e::class.java.simpleName
    val thread = t?.name ?: "Unknown"
    val message = e.message
    val stackTrace = e.stackTrace
}