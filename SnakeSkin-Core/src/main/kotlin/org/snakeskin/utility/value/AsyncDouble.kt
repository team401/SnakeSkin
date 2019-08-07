package org.snakeskin.utility.value

import kotlin.reflect.KProperty

/**
 * @author Cameron Earle
 * @version 8/7/2019
 *
 */
class AsyncDouble(initialValue: Double) {
    private val lock = Any()
    private var value = initialValue

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Double {
        synchronized(lock) {
            return value
        }
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Double) {
        synchronized(lock) {
            this.value = value
        }
    }
}