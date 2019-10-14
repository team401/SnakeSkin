package org.snakeskin.utility.value

class HistoryValue<T>(initialValue: T) {
    var last = initialValue
        @Synchronized get
        private set

    var current = initialValue
        @Synchronized get
        private set

    @Synchronized
    fun update(newValue: T) {
        last = current
        current = newValue
    }

    /**
     * Returns true if the value changed from its previous value since the last call to "update"
     */
    fun changed(): Boolean {
        return current != last
    }
}