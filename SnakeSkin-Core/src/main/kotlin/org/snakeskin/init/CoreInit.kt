package org.snakeskin.init

import org.snakeskin.registry.HIDControllersRegistry
import org.snakeskin.registry.SubsystemsRegistry
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
    }

    override fun postStartup() {
        SnakeskinRuntime.startRealTimeExecutors()
        HIDControllersRegistry.initAll()
        SubsystemsRegistry.initAll()
    }
}