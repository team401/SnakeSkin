package org.snakeskin.utility.value

import kotlin.reflect.KProperty

/**
 * @author Cameron Earle
 * @version 8/7/2019
 *
 */
class SelectableByte(private vararg val values: Byte) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Byte {
        if (SelectableValue.selected > values.lastIndex) {
            println("Warning: Selectable value '${property.name}' does not define a value for index $${SelectableValue.selected}!  Returning first value.")
            return values.first()
        }
        return values[SelectableValue.selected]
    }
}