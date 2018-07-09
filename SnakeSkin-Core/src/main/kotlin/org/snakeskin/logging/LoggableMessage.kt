package org.snakeskin.logging

import org.snakeskin.ability.ALoggable

/**
 * @author Cameron Earle
 * @version 8/26/17
 */
class LoggableMessage(val message: String, val level: LogLevel = LogLevel.INFO): ALoggable {
    override val type = "message"
}