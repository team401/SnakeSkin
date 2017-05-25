package org.team401.snakeskin.logic

/*
 * SnakeSkin - Created on 5/24/17
 * Author: Zachary Kozar
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at the project root.
 */

/**
 * An axis that points in a direction.
 *
 * @author Zachary Kozar
 * @version 5/24/17
 */
interface DirectionalAxis {

    /**
     * Get the current direction of the axis, usually between 0-359 (as in degrees).
     * Returns -1 when there is no current direction.
     */
    fun getDirection(): Int
}