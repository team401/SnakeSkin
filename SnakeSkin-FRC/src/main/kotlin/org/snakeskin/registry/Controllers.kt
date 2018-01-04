package org.snakeskin.registry

import org.snakeskin.annotation.PostStartup
import org.snakeskin.controls.ControlPoller
import org.snakeskin.controls.Controller

/*
 * snakeskin - Created on 12/24/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 12/24/17
 */
object Controllers: Registry<Controller>() {
    @PostStartup @JvmStatic internal fun initAll() {
        registry.forEach {
            ControlPoller.addController(it)
        }
        ControlPoller.init()
    }
}