package org.team401.snakeskin.logging

import com.google.gson.Gson
import org.team401.snakeskin.ability.ALoggable

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
open class LoggableValue(val name: String, val getter: () -> Any): ALoggable {
    override val type = "value"
}