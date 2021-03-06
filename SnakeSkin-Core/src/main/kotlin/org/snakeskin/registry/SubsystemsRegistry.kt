package org.snakeskin.registry

import org.snakeskin.subsystem.Subsystem

/**
 * @author Cameron Earle
 * @version 7/16/17
 *
 * The subsystem registry, which all subsystems that need to be loaded should be added to
 */
object SubsystemsRegistry: Registry<Subsystem>() {
    @JvmStatic internal fun initAll() {
        registry.forEach {
            it.init()
        }
    }

    @JvmStatic fun testAll() {
        registry.forEach {
            it.checkSubsystem()
        }
    }
}