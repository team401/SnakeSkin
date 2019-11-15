package org.snakeskin.registry

import org.snakeskin.hid.HIDController
import org.snakeskin.hid.HIDUpdater

object HIDControllersRegistry: Registry<HIDController>() {
    @JvmStatic internal fun initAll() {
        registry.forEach {
            it.onRegister()
            HIDUpdater.addController(it)
        }
    }
}