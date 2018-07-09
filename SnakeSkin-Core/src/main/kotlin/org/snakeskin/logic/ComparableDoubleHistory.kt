package org.snakeskin.logic

/**
 * @author Cameron Earle
 * @version 9/11/17
 */
class ComparableDoubleHistory: History<Double>() {
    fun changedWithin(deadband: Double): Boolean {
        if (last != null && current != null) {
            if ((last!! + deadband) <= current!!) {
                return true
            }
            if ((last!! - deadband) >= current!!) {
                return true
            }
        }
        return false
    }

    fun wentAbove(value: Double): Boolean {
        if (last != null && current != null) {
            if (current!! >= value && last!! < value) {
                return true
            }
        }
        return false
    }

    fun wentBelow(value: Double): Boolean {
        if (last != null && current != null) {
            if (current!! <= value && last!! > value) {
                return true
            }
        }
        return false
    }
}