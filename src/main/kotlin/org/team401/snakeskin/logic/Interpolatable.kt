package org.team401.snakeskin.logic

/*
 * SnakeSkin - Created on 5/22/17
 * Author: Zachary Kozar
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at the project root.
 */

/**
 * @author Zachary Kozar
 * @version 5/22/17
 *
 * Interpolatable is an interface used by an Interpolating Tree as the Value type.
 * Given two end points and an interpolation parameter on [0, 1], it calculates
 * a new Interpolatable representing the interpolated value.
 * @param <T>The Type of Interpolatable</T>
 */
interface Interpolatable<T> {
    /**
     * Interpolates between this value and an other value according to a given
     * parameter. If x is 0, the method should return this value. If x is 1, the
     * method should return the other value. If 0 < x < 1, the return value
     * should be interpolated proportionally between the two.
     * @param other
     * *            The value of the upper bound
     * *
     * @param x
     * *            The requested value. Should be between 0 and 1.
     * *
     * @return Interpolatable<T> The estimated average between the surrounding
     * *         data
    </T> */
    fun interpolate(other: T, x: Double): T
}