package org.snakeskin.init

import org.snakeskin.registry.Controllers
import org.snakeskin.registry.Sensors

/**
 * @author Cameron Earle
 * @version 11/29/2018
 *
 */
class FrcInit: Initializer {
    override fun preStartup() {
    }

    override fun postStartup() {
        Controllers.initAll()
        Sensors.initAll()
    }
}