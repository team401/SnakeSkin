package org.snakeskin.utility.value

class HistoryChar(initialValue: Char = Char.MIN_VALUE) {
    var last = initialValue
        @Synchronized get
        private set

    var current = initialValue
        @Synchronized get
        private set

    @Synchronized
    fun update(newValue: Char) {
        last = current
        current = newValue
    }

    /**
     * Returns true if the value changed from its previous value since the last call to "update"
     */
    fun changed(): Boolean {
        return current != last
    }

    //Numeric operations

    /**
     * Returns the difference between the current value and the last value
     * Returns an Int, as char subtraction in Kotlin returns an Int
     */
    fun delta(): Int {
        return current - last
    }
}