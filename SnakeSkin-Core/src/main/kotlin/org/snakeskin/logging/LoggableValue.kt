package org.snakeskin.logging

import org.snakeskin.ability.ILoggable

/**
 * @author Cameron Earle
 * @version 8/26/17
 */
open class LoggableValue(val name: String, val getter: () -> Any): ILoggable {
    override val type = "value"
}