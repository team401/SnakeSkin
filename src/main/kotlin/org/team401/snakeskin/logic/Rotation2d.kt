package org.team401.snakeskin.logic

/*
 * SnakeSkin - Created on 5/22/17
 * Author: Zachary Kozar
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at the project root.
 */

import org.team401.snakeskin.ability.AInterpolatable
import java.text.DecimalFormat

/**
 * @author Zachary Kozar
 * @version 5/22/17
 *
 * A rotation in a 2d coordinate frame represented a point on the unit circle
 * (cosine and sine).
 * Inspired by Sophus (https://github.com/strasdat/Sophus/tree/master/sophus)
 */
class Rotation2d : AInterpolatable<Rotation2d> {

    private var cosAngle: Double = 0.0
    private var sinAngle: Double = 0.0

    constructor(x: Double = 1.0, y: Double = 0.0, normalize: Boolean = false) {
        cosAngle = x
        sinAngle = y
        if (normalize)
            normalize()
    }

    constructor(other: Rotation2d) {
        cosAngle = other.cosAngle
        sinAngle = other.sinAngle
    }

    /**
     * From trig, we know that sin^2 + cos^2 == 1, but as we do math on this
     * object we might accumulate rounding errors. Normalizing forces us to
     * re-scale the sin and cos to reset rounding errors.
     */
    fun normalize() {
        val magnitude = Math.hypot(cosAngle, sinAngle)
        if (magnitude > kEpsilon) {
            sinAngle /= magnitude
            cosAngle /= magnitude
        } else {
            sinAngle = 0.0
            cosAngle = 1.0
        }
    }

    fun cos(): Double {
        return cosAngle
    }

    fun sin(): Double {
        return sinAngle
    }

    fun tan(): Double {
        if (cosAngle < kEpsilon)
            return if (sinAngle >= 0.0)
                Double.POSITIVE_INFINITY
            else
                Double.NEGATIVE_INFINITY
        return sinAngle / cosAngle
    }

    val radians: Double
        get() = Math.atan2(sinAngle, cosAngle)

    val degrees: Double
        get() = Math.toDegrees(radians)

    /**
     * We can rotate this Rotation2d by adding together the effects of it and
     * another rotation.
     * @param other
     * *            The other rotation. See:
     * *            https://en.wikipedia.org/wiki/Rotation_matrix
     * *
     * @return This rotation rotated by other.
     */
    fun rotateBy(other: Rotation2d): Rotation2d {
        return Rotation2d(cosAngle * other.cosAngle - sinAngle * other.sinAngle,
                cosAngle * other.sinAngle + sinAngle * other.cosAngle, true)
    }

    /**
     * The inverse of a Rotation2d "undoes" the effect of this rotation.
     * @return The opposite of this rotation.
     */
    fun inverse(): Rotation2d {
        return Rotation2d(cosAngle, -sinAngle, false)
    }

    override fun interpolate(other: Rotation2d, x: Double): Rotation2d {
        if (x <= 0)
            return Rotation2d(this)
        else if (x >= 1)
            return Rotation2d(other)

        return rotateBy(fromRadians(inverse().rotateBy(other).radians * x))
    }

    override fun toString(): String {
        return "(" + DecimalFormat("#0.000").format(degrees) + " deg)"
    }

    companion object {

        private val kEpsilon = 1E-9

        fun fromRadians(radians: Double): Rotation2d {
            return Rotation2d(Math.cos(radians), Math.sin(radians), false)
        }

        fun fromDegrees(degrees: Double): Rotation2d {
            return fromRadians(Math.toRadians(degrees))
        }
    }
}