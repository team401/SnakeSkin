package org.snakeskin.utility.value

import kotlin.reflect.KProperty

/**
 * @author Cameron Earle
 * @version 8/7/2019
 *
 */
class AsyncInt(initialValue: Int) {
    private val lock = Any()
    private var value = initialValue

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        synchronized(lock) {
            return value
        }
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        synchronized(lock) {
            this.value = value
        }
    }
}