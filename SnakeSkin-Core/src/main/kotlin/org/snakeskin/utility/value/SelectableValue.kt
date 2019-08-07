package org.snakeskin.utility.value

import kotlin.reflect.KProperty

/**
 * @author Cameron Earle
 * @version 8/7/2019
 *
 */
class SelectableValue<out T>(private vararg val values: T) {
    companion object {
        var selected by AsyncInt(0)
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        if (selected > values.lastIndex) {
            println("Warning: Selectable value '${property.name}' does not define a value for index $selected!  Returning first value.")
            return values.first()
        }
        return values[selected]
    }
}