package org.snakeskin

import org.snakeskin.controls.ControlPoller
import org.snakeskin.factory.ExecutorFactory
import org.snakeskin.logging.LoggerManager
import org.snakeskin.registry.Controllers
import org.snakeskin.registry.Sensors
import org.snakeskin.registry.Subsystems

/*
 * snakeskin - Created on 7/16/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 7/16/17
 */

object InitManager {

    /**
     * This method runs before SETUP is loaded
     */
    @JvmStatic fun preStartup() {
        ExecutorFactory.init()
        LoggerManager.init()
    }

    /**
     * This method runs after SETUP is loaded
     */
    @JvmStatic fun postStartup() {
        Controllers.initAll()
        ControlPoller.init()
        Subsystems.initAll()
        Sensors.initAll()
    }
}