package org.snakeskin.dsl

import edu.wpi.first.wpilibj.DigitalInput
import edu.wpi.first.wpilibj.DigitalOutput
import edu.wpi.first.wpilibj.Solenoid
import edu.wpi.first.wpilibj.interfaces.Gyro
import org.snakeskin.logic.Rotation2d
import org.snakeskin.logic.Switch

/**
 * @author Zachary Kozar
 * @version 6/2/17
 *
 * Domain Specific Language package
 * Extension functions
 */

// Axis

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

operator fun Rotation2d.compareTo(other: Rotation2d): Int {
    if (this.degrees > other.degrees)
        return 1
    else if (this.degrees < other.degrees)
        return -1
    return 0
}

// Switch

fun Switch.and(other: Switch): Switch {
    return Switch { this.isTriggered() && other.isTriggered() }
}

fun Switch.or(other: Switch): Switch {
    return Switch { this.isTriggered() || other.isTriggered() }
}

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