package org.snakeskin.logic

import java.util.concurrent.atomic.AtomicReference
import kotlin.reflect.KProperty

/*
 * snakeskin - Created on 12/22/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 12/22/17
 */

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