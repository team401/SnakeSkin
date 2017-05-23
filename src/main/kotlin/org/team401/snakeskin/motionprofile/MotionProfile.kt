package org.team401.snakeskin.motionprofile

import com.ctre.CANTalon
import java.io.File

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
 */
class MotionProfile internal constructor(val name: String, private val positions: DoubleArray,
                                         private val speeds: DoubleArray,
                                         private val durations: IntArray) : Iterable<CANTalon.TrajectoryPoint> {

    override fun iterator() = object : ListIterator<CANTalon.TrajectoryPoint> {
        override fun hasNext(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun hasPrevious(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun next(): CANTalon.TrajectoryPoint {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun nextIndex(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun previous(): CANTalon.TrajectoryPoint {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun previousIndex(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

    var currentIndex = 0
    val totalPoints = positions.size

}

fun parse(name: String, path: String): MotionProfile {
    val empty = MotionProfile(name, DoubleArray(0), DoubleArray(0), IntArray(0))
    val file = File(path)
    val lines = try {
        file.readLines()
    } catch (e: Exception) {
        println("Could not find motion profile $path")
        return empty
    }

    val positions = ArrayList<Double>()
    val speeds = ArrayList<Double>()
    val durations = ArrayList<Int>()

    try {
        lines.forEach {
            val entries = it.substring(1, it.length - 3).split(",")
            positions.add(entries[0].toDouble())
            speeds.add(entries[1].toDouble())
            durations.add((entries[2].toDouble() + .5).toInt())
        }
    } catch (e: Exception) {
        print("Could not parse motion profile $path")
        return empty
    }

    return MotionProfile(name, positions.toDoubleArray(), speeds.toDoubleArray(), durations.toIntArray())
}
