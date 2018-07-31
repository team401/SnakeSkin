package org.snakeskin.controls

/**
 * @author Cameron Earle
 * @version 7/30/2018
 *
 */
interface ControllerProvider {
    fun readAxis(id: Int): Double
    fun readButton(id: Int): Boolean
    fun readHat(id: Int): Int
}