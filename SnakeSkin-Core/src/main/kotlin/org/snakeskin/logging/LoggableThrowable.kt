package org.snakeskin.logging

import org.snakeskin.ability.ALoggable

/**
 * @author Cameron Earle
 * @version 8/26/17
 */
class LoggableThrowable(e: Throwable, t: Thread?): ALoggable {
    override val type = "exception"

    val name = e::class.java.simpleName
    val thread = t?.name ?: "Unknown"
    val message = e.message
    val stackTrace = e.stackTrace
}