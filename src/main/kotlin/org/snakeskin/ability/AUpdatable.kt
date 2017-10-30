package org.snakeskin.ability

/*
 * snakeskin - Created on 8/15/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 8/15/17
 */
interface AUpdatable<in T> {
    fun update(newValue: T)
}