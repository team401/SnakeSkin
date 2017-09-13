package org.team401.snakeskin.logic

/*
 * snakeskin - Created on 9/11/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

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
}