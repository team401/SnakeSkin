package org.snakeskin.utility.value

import kotlin.reflect.KProperty

/**
 * @author Cameron Earle
 * @version 8/7/2019
 *
 */
class AsyncBoolean(initialValue: Boolean) {
    private val lock = Any()
    private var value = initialValue

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Boolean {
        synchronized(lock) {
            return value
        }
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Boolean) {
        synchronized(lock) {
            this.value = value
        }
    }
}