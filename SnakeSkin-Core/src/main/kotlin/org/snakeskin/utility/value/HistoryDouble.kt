package org.snakeskin.utility.value

class HistoryDouble(initialValue: Double = Double.NaN) {
    var last = initialValue
        @Synchronized get
        private set

    var current = initialValue
        @Synchronized get
        private set

    @Synchronized
    fun update(newValue: Double) {
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
     */
    fun delta(): Double {
        return current - last
    }
}