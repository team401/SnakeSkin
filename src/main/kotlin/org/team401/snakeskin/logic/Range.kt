package org.team401.snakeskin.logic

/*
 * SnakeSkin - Created on 5/24/17
 * Author: Zachary Kozar
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at the project root.
 */

/**
 * @author Zachary Kozar
 * @version 5/24/17
 */
interface Range {

    fun read(): Double
}

fun Range.scale(modifier: Double) = object : Range {
    override fun read() = this@scale.read()*modifier
}