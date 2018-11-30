package org.snakeskin.init

import org.snakeskin.factory.ExecutorFactory
import org.snakeskin.registry.Subsystems

/**
 * @author Cameron Earle
 * @version 11/29/2018
 *
 */
class CoreInit: Initializer {
    override fun preStartup() {
        ExecutorFactory.init()
        println("CoreInit preStartup")
    }

    override fun postStartup() {
        Subsystems.initAll()
        println("CoreInit postStartup")
    }
}