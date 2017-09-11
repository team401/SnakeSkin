package org.team401.snakeskin.sensors

import org.team401.snakeskin.Constants
import org.team401.snakeskin.factory.ExecutorFactory
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.TimeUnit

/*
 * snakeskin - Created on 9/10/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 9/10/17
 */
object SensorPoller {
    private val EXECUTOR = ExecutorFactory.getExecutor("SensorPoller")
    private val pollGroups = ConcurrentHashMap<Long, Vector<Sensor<*>>>()

    private fun scheduleNewPollGroup(group: Long) {
        EXECUTOR.scheduleAtFixedRate({
            pollGroups[group]?.forEach {
                it.pollImpl()
            }
        }, 0L, group, TimeUnit.MILLISECONDS)
    }

    fun addSensor(sensor: Sensor<*>) {
        if (sensor.pollRate != -1L) {
            if (!pollGroups.contains(sensor.pollRate)) {
                pollGroups.put(sensor.pollRate, Vector())
                scheduleNewPollGroup(sensor.pollRate)
            }

            pollGroups[sensor.pollRate]?.addElement(sensor)
        }
    }
}