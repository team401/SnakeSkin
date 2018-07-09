package org.snakeskin.dsl

import org.snakeskin.ability.AInvertable
import org.snakeskin.component.Piston

/**
 * @author Cameron Earle
 * @version 8/18/17
 */
object Components {
    class InvertableBuilder<out T: AInvertable>(val item: T): Builder<T> {
        override fun build() = item
        var inverted: Boolean
            get() = item.inverted
            set(value) { item.inverted = value }

        fun invert() = item.invert()
    }

    fun piston(port: Int, extensionTime: Long = 0, retractionTime: Long = 0, pcm: Int = 0, setup: InvertableBuilder<Piston>.() -> Unit = {}): Piston {
        val builder = InvertableBuilder(Piston(port, pcm, extensionTime, retractionTime))
        builder.setup()
        return builder.build()
    }
}