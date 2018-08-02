package org.snakeskin.rt

/**
 * @author Cameron Earle
 * @version 8/1/18
 */
interface RealTimeSchedulingProvider {
    val task: Runnable

    fun startPeriodic(rate: Double)
}