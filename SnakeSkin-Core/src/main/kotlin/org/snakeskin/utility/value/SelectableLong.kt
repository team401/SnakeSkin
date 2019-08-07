package org.snakeskin.utility.value

import kotlin.reflect.KProperty

/**
 * @author Cameron Earle
 * @version 8/7/2019
 *
 */
class SelectableLong(private vararg val values: Long) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Long {
        if (SelectableValue.selected > values.lastIndex) {
            println("Warning: Selectable value '${property.name}' does not define a value for index $${SelectableValue.selected}!  Returning first value.")
            return values.first()
        }
        return values[SelectableValue.selected]
    }
}