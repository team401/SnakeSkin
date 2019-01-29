package org.snakeskin.controls

import org.snakeskin.ability.AReadable

/**
 * @author Cameron Earle
 * @version 7/16/17
 */
class Hat(private val provider: ControllerProvider,
          private val hat: Int,
          private val enabled: Controller.EnabledReference): AReadable<Int> {
    override fun read(): Int {
        if (!enabled.enabled) return default
        return provider.readHat(hat)
    }

    val default = 0
}