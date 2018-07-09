package org.snakeskin.sensors

/**
 * @author Cameron Earle
 * @version 9/11/17
 */
interface DistanceSensor {
    fun getInches(): Double
    fun getFeet(): Double
    fun getYards(): Double
}