package org.snakeskin.utility.value

class HistoryBoolean(initialValue: Boolean = false) {
    var last = initialValue
        @Synchronized get
        private set

    var current = initialValue
        @Synchronized get
        private set

    @Synchronized
    fun update(newValue: Boolean) {
        last = current
        current = newValue
    }

    /**
     * Returns true if the value changed from its previous value since the last call to "update"
     */
    fun changed(): Boolean {
        return current != last
    }

    //Boolean operations

    /**
     * Returns true if the current state of the history is a "rising edge",
     * meaning the last value was false and the current value is true
     */
    fun isRisingEdge(): Boolean {
        return !last && current
    }

    /**
     * Returns true if the current state of the history is a "falling edge",
     * meaning the last value was true and the current value is false
     */
    fun isFallingEdge(): Boolean {
        return last && !current
    }
}