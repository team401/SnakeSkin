package org.snakeskin.ability

interface AInterpolatable<T> {
    fun interpolate(other: T, x: Double): T
}