package org.snakeskin.controls

import org.snakeskin.ability.AInvertable
import org.snakeskin.ability.AReadable
import java.util.concurrent.atomic.AtomicReference

/**
 * @author Cameron Earle
 * @version 7/16/17
 */
class Button(override var inverted: Boolean = false,
             private val provider: ControllerProvider,
             private val button: Int,
             private val enabled: AtomicReference<Boolean>): AReadable<Boolean>, AInvertable {
    override fun read(): Boolean {
        if (!enabled.get()) return default

        if (inverted)
            return !provider.readButton(button)
        return provider.readButton(button)
    }

    val default = inverted
}