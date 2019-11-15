package org.snakeskin.init

import org.snakeskin.registry.Sensors
import org.snakeskin.runtime.SnakeskinModules
import org.snakeskin.runtime.SnakeskinRuntime

/**
 * @author Cameron Earle
 * @version 11/29/2018
 *
 */
class FrcInit: Initializer {
    override fun preStartup() {
        SnakeskinRuntime.registerModule(SnakeskinModules.FRC)
    }

    override fun postStartup() {
        Sensors.initAll()
    }
}