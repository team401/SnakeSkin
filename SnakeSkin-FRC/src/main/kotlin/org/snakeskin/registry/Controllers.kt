package org.snakeskin.registry

import org.snakeskin.hid.HIDController
import org.snakeskin.hid.HIDUpdater

/**
 * @author Cameron Earle
 * @version 12/24/17
 */
object Controllers: Registry<HIDController>() {
    @JvmStatic fun initAll() {
        registry.forEach {
            HIDUpdater.addController(it) //Add the controller to the poller
        }
    }
}