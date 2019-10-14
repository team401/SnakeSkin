package org.snakeskin.utility.value

class HistoryByte(initialValue: Byte = Byte.MIN_VALUE) {
    var last = initialValue
        @Synchronized get
        private set

    var current = initialValue
        @Synchronized get
        private set

    @Synchronized
    fun update(newValue: Byte) {
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
     * Returns an Int, as byte subtraction in Kotlin returns an Int
     */
    fun delta(): Int {
        return current - last
    }
}