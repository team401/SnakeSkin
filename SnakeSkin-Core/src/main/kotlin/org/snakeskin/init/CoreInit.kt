package org.snakeskin.init

import org.snakeskin.factory.ExecutorFactory
import org.snakeskin.registry.Subsystems
import org.snakeskin.runtime.SnakeskinModules
import org.snakeskin.runtime.SnakeskinRuntime

/**
 * @author Cameron Earle
 * @version 11/29/2018
 *
 */
class CoreInit: Initializer {
    override fun preStartup() {
        SnakeskinRuntime.registerModule(SnakeskinModules.CORE)
        ExecutorFactory.init()
    }

    override fun postStartup() {
        Subsystems.initAll()
    }
}