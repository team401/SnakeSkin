package org.snakeskin.logic

import org.snakeskin.ability.AUpdatable

/**
 * @author Cameron Earle
 * @version 7/18/17
 *
 * A simple class that tracks history of an object
 */
@Deprecated("Use new History[TYPE] classes.", ReplaceWith("org.snakeskin.utility.value.History[TYPE]"))
open class History<T>: AUpdatable<T> {
    var last: T? by LockingDelegate(null); private set
    var current: T? by LockingDelegate(null); private set

    @Synchronized override fun update(newValue: T) {
        last = current
        current = newValue
    }

    fun changed(): Boolean {
        return (current != last && current != null)
    }
}