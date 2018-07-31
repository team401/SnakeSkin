package org.snakeskin.controls

import org.snakeskin.ability.AReadable
import java.util.concurrent.atomic.AtomicReference

/**
 * @author Cameron Earle
 * @version 7/16/17
 */
class Hat(private val provider: ControllerProvider,
          private val hat: Int,
          private val enabled: AtomicReference<Boolean>): AReadable<Int> {
    override fun read(): Int {
        if (!enabled.get()) return default
        return provider.readHat(hat)
    }

    val default = 0
}