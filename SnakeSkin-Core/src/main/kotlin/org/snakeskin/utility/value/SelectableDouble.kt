package org.snakeskin.utility.value

import kotlin.reflect.KProperty

/**
 * @author Cameron Earle
 * @version 8/7/2019
 *
 */
class SelectableDouble(private vararg val values: Double) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Double {
        if (SelectableValue.selected > values.lastIndex) {
            println("Warning: Selectable value '${property.name}' does not define a value for index $${SelectableValue.selected}!  Returning first value.")
            return values.first()
        }
        return values[SelectableValue.selected]
    }
}