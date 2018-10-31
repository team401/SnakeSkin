package org.snakeskin.logic

/**
 * @author Cameron Earle
 * @version 7/16/17
 */
object Direction {
    const val CENTER = -1
    const val NORTH = 0
    const val NORTHEAST = 45
    const val EAST = 90
    const val SOUTHEAST = 135
    const val SOUTH = 180
    const val SOUTHWEST = 225
    const val WEST = 270
    const val NORTHWEST = 315

    /**
     * Returns the vertical index of the given direction.  This is 1.0 for up, -1.0 for down, and 0.0 for any other direction
     */
    fun verticalIndex(value: Int): Double {
        when (value) {
            NORTH -> return 1.0
            SOUTH -> return -1.0
        }
        return 0.0
    }

    /**
     * Returns the horizontal index of the given direction.  This is 1.0 for right, -1.0 for left, and 0.0 for any other direction
     */
    fun horizontalIndex(value: Int): Double {
        when (value) {
            EAST -> return 1.0
            WEST -> return -1.0
        }
        return 0.0
    }
}