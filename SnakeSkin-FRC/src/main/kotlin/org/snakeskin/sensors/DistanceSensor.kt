package org.snakeskin.sensors

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

interface DistanceSensor {
    fun getInches(): Double
    fun getFeet(): Double
    fun getYards(): Double
}