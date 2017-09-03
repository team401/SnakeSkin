package org.team401.snakeskin

import org.team401.snakeskin.controls.ControlPoller
import org.team401.snakeskin.factory.ExecutorFactory
import org.team401.snakeskin.logging.LoggerManager
import org.team401.snakeskin.registry.Controllers
import org.team401.snakeskin.registry.Subsystems

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
        Subsystems.initAll()
        Controllers.initAll()
        ControlPoller.init()
    }
}