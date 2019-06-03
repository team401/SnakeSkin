package org.snakeskin.component

import org.snakeskin.measure.distance.linear.LinearDistanceMeasureInches
import org.snakeskin.template.TankDrivetrainGeometryTemplate

/**
 * @author Cameron Earle
 * @version 1/9/2019
 *
 */
interface IDifferentialDrivetrain<out G: IGearbox> {
    val left: G
    val right: G

    fun both(action: G.() -> Unit) {
        left.action()
        right.action()
    }

    /**
     * The geometric wheelbase of the drivetrain.  This should be a parameter measured either in CAD or on the hardware.
     */
    var wheelbase: LinearDistanceMeasureInches

    /**
     * The geometric wheel radius of the drivetrain's wheels.  This should be measured with a geometric test on the hardware.
     */
    var wheelRadius: LinearDistanceMeasureInches

    /**
     * Updates the geometry from the template provided
     */
    fun updateGeometry(template: TankDrivetrainGeometryTemplate)

    /**
     * Operates the drivetrain in "tank" mode, meaning the left setpoint sets the speed of the left gearbox, and the
     * right setpoint is applied to the right
     */
    fun tank(leftSetpoint: Double, rightSetpoint: Double)

    /**
     * Operates the drivetrain in "arcade" mode, meaning the translation and rotation are used to control the robot
     */
    fun arcade(translation: Double, rotation: Double)

    /**
     * Stops the drivetrain
     */
    fun stop()
}