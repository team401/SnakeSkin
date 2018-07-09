package org.snakeskin.logging

import org.snakeskin.ability.ALoggable

/**
 * @author Cameron Earle
 * @version 8/26/17
 */
open class LoggableValue(val name: String, val getter: () -> Any): ALoggable {
    override val type = "value"
}