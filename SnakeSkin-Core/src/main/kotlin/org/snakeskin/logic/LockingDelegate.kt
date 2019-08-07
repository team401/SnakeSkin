package org.snakeskin.logic

import java.util.concurrent.atomic.AtomicReference
import kotlin.reflect.KProperty

/**
 * @author Cameron Earle
 * @version 12/22/17
 */
@Deprecated("Replaced with new type-specific async delegates", ReplaceWith("Async*", "org.snakeskin.utility.async.*"))
class LockingDelegate<T>(initialValue: T) {
    private val lock = Any()
    private var value = initialValue

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        synchronized(lock) {
            return value
        }
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        synchronized(lock) {
            this.value = value
        }
    }
}