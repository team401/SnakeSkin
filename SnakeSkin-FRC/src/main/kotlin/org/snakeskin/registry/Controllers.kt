package org.snakeskin.registry

import org.snakeskin.annotation.PostStartup
import org.snakeskin.controls.ControlPoller
import org.snakeskin.controls.Controller

/**
 * @author Cameron Earle
 * @version 12/24/17
 */
object Controllers: Registry<Controller>() {
    @PostStartup @JvmStatic fun initAll() {
        println("SnakeSkin-FRC: Controllers Registry Loaded") //TODO remove debug statement

        registry.forEach {
            ControlPoller.addController(it)
        }
    }
}