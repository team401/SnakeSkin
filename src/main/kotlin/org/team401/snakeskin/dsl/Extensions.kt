package org.team401.snakeskin.dsl

import edu.wpi.first.wpilibj.DigitalInput
import edu.wpi.first.wpilibj.DigitalOutput
import edu.wpi.first.wpilibj.Solenoid
import edu.wpi.first.wpilibj.interfaces.Gyro
import org.team401.snakeskin.logic.Axis
import org.team401.snakeskin.logic.Rotation2d
import org.team401.snakeskin.logic.Switch

/*
 * SnakeSkin - Created on 7/3/17
 * Author: Zachary Kozar
 *
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at the project root.
 */

/**
 * @author Zachary Kozar
 * @version 6/2/17
 *
 * Domain Specific Language package
 * Extension functions
 */

// Axis

fun Axis.invert(): Axis {
    val inverted = Axis(this.deadband) { this.read() }
    inverted scale scaling
    return inverted
}

// Gyro

fun Gyro.getAngleAsRotation(): Rotation2d {
    return Rotation2d.fromDegrees(this.angle)
}

// Rotation2d

operator fun Rotation2d.plus(other: Rotation2d): Rotation2d {
    return this.rotateBy(other)
}

operator fun Rotation2d.plus(degrees: Double): Rotation2d {
    return Rotation2d.fromDegrees(this.degrees + degrees)
}

operator fun Rotation2d.inc(): Rotation2d {
    return this + 1.0
}

operator fun Rotation2d.minus(other: Rotation2d): Rotation2d {
    return this.rotateBy(-other)
}

operator fun Rotation2d.minus(degrees: Double): Rotation2d {
    return Rotation2d.fromDegrees(this.degrees - degrees)
}

operator fun Rotation2d.dec(): Rotation2d {
    return this - 1.0
}

operator fun Rotation2d.unaryMinus(): Rotation2d {
    return this.inverse()
}

operator fun Rotation2d.times(other: Rotation2d): Rotation2d {
    return this * other.degrees
}

operator fun Rotation2d.times(degrees: Double): Rotation2d {
    return Rotation2d.fromDegrees(this.degrees * degrees)
}

operator fun Rotation2d.div(other: Rotation2d): Rotation2d {
    return this / other.degrees
}

operator fun Rotation2d.div(degrees: Double): Rotation2d {
    return Rotation2d.fromDegrees(this.degrees / degrees)
}

// Switch

fun Switch.invert(): Switch {
    return Switch { !this.isTriggered() }
}

fun Solenoid.asSwitch(): Switch {
    return Switch { this.get() }
}

fun DigitalInput.asSwitch(): Switch {
    return Switch { this.get() }
}

fun DigitalOutput.asSwitch(): Switch {
    return Switch { this.get() }
}