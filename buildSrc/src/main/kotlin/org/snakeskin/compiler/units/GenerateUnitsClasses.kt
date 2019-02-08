package org.snakeskin.compiler.units

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.File

/**
 * @author Cameron Earle
 * @version 2/6/2019
 *
 */
open class GenerateUnitsClasses: DefaultTask() {
    companion object BaseComponents {
        //Linear distance
        val inches = UnitComponent(UnitType.LINEAR_DISTANCE, "Inch", "Inches", "in", 1.0) //BASE
        val meters = UnitComponent(UnitType.LINEAR_DISTANCE, "Meter", "Meters", "m", 39.3701)
        val centimeters = UnitComponent(UnitType.LINEAR_DISTANCE, "Centimeter", "Centimeters", "cm", 0.393701)
        val feet = UnitComponent(UnitType.LINEAR_DISTANCE, "Foot", "Feet", "ft", 12.0)
        val linearDistance = arrayListOf(inches, meters, centimeters, feet)

        //Angular distance
        val radians = UnitComponent(UnitType.ANGULAR_DISTANCE, "Radian", "Radians", "rad", 1.0) //BASE
        val degrees = UnitComponent(UnitType.ANGULAR_DISTANCE, "Degree", "Degrees", "deg", Math.PI / 180.0)
        val revolutions = UnitComponent(UnitType.ANGULAR_DISTANCE, "Revolution", "Revolutions", "rev", 2.0 * Math.PI)
        val angularDistance = arrayListOf(radians, degrees, revolutions)

        //Time
        val seconds = UnitComponent(UnitType.TIME, "Second", "Seconds", "s", 1.0) //BASE
        val milliseconds = UnitComponent(UnitType.TIME, "Millisecond", "Milliseconds", "ms", 0.001)
        val minutes = UnitComponent(UnitType.TIME, "Minute", "Minutes", "min", 60.0)
        val time = arrayListOf(seconds, milliseconds, minutes)
    }

    private val units = arrayListOf<UnitDefinition>()

    private fun addGroup(name: String, items: List<UnitComponent>) {
        items.forEachIndexed {
            i, c ->
            units.add(UnitDefinition.createSingle(i == 0, name, c))
        }
    }

    private fun getGroup(group: String): List<UnitDefinition> {
        val toReturn = arrayListOf<UnitDefinition>()
        units.forEach {
            if (it.group == group) {
                toReturn.add(it)
            }
        }
        return toReturn
    }

    private fun multiplexPer(group: String, upper: List<UnitDefinition>, lower: List<UnitDefinition>): List<UnitDefinition> {
        val toReturn = arrayListOf<UnitDefinition>()
        upper.forEach {
            top ->
            lower.forEach {
                bottom ->
                toReturn.add(top.createPer(top.isBase && bottom.isBase, group, bottom.components[0])) //NOTE: this only takes the first unit from the lower
            }
        }
        return toReturn
    }

    private fun preClean() {
        project.delete("${project.rootDir}/SnakeSkin-Core/src/main/generated")
        project.mkdir("${project.rootDir}/SnakeSkin-Core/src/main/generated")
    }

    /**
     * Registers the flat map of units to be assembled
     */
    private fun registerUnits() {
        addGroup("distance.linear", linearDistance)
        addGroup("distance.angular", angularDistance)
        addGroup("time", time)

        units.addAll(multiplexPer("velocity.linear", getGroup("distance.linear"), getGroup("time")))
        units.addAll(multiplexPer("velocity.angular", getGroup("distance.angular"), getGroup("time")))
        units.addAll(multiplexPer("acceleration.linear", getGroup("velocity.linear"), getGroup("time")))
        units.addAll(multiplexPer("acceleration.angular", getGroup("velocity.angular"), getGroup("time")))
    }

    /**
     * Categorizes the flat map of units into groups, and then cross references to generate all conversion factors
     */
    private fun assembleUnits(directory: File) {
        val linearDistance = getGroup("distance.linear")
        val angularDistance = getGroup("distance.angular")
        val time = getGroup("time")
        val linearVelocity = getGroup("velocity.linear")
        val angularVelocity = getGroup("velocity.angular")
        val linearAcceleration = getGroup("acceleration.linear")
        val angularAcceleration = getGroup("acceleration.angular")

        UnitClassGenerator.generateGroup(directory, linearDistance)
        UnitClassGenerator.generateGroup(directory, angularDistance)
        UnitClassGenerator.generateGroup(directory, time)
        UnitClassGenerator.generateGroup(directory, linearVelocity)
        UnitClassGenerator.generateGroup(directory, angularVelocity)
        UnitClassGenerator.generateGroup(directory, linearAcceleration)
        UnitClassGenerator.generateGroup(directory, angularAcceleration)

        UnitClassGenerator.generateDsl(directory,
                linearDistance,
                angularDistance,
                time,
                linearVelocity,
                angularVelocity,
                linearAcceleration,
                angularAcceleration
                )
    }

    @TaskAction
    fun run() {
        preClean()
        registerUnits()
        assembleUnits(File("${project.rootDir}/SnakeSkin-Core/src/main/generated"))
    }
}