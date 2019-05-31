package org.snakeskin.utility

import org.snakeskin.logic.LockingDelegate
import kotlin.reflect.KProperty

/**
 * Type delegate that allows multiple values to exist for a single field.  Which one is used
 * depends on the value configured in the "selected" parameter of the companion.  This class
 * can be used to store multiple sets of configuration parameters for practice vs competition
 * robots.
 */
class Selectable<out T>(vararg val values: T) {
    companion object {
        var selected by LockingDelegate(0)
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        if (selected > values.lastIndex) {
            println("Warning: Selectable value '${property.name}' does not define a value for index $selected!  Returning first value.")
            return values.first()
        }
        return values[selected]
    }
}