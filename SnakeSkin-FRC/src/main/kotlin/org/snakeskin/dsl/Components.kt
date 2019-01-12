package org.snakeskin.dsl

import org.snakeskin.ability.AInvertable

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
}