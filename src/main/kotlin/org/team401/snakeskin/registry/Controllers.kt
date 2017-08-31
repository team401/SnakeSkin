package org.team401.snakeskin.registry

import org.team401.snakeskin.controls.Controller
import org.team401.snakeskin.controls.ControlPoller

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
object Controllers: Registry<Controller>() {
    override fun initAll() {
        registry.forEach {
            ControlPoller.addController(it)
        }
    }
}