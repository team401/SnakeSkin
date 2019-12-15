package org.snakeskin.component

import org.snakeskin.component.provider.IYawProvider
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureDegrees
import org.snakeskin.template.DifferentialDrivetrainGeometry

/**
 * Represents a differential drivetrain.  A differential drivetrain has left and right gearboxes and a yaw source
 */
interface IDifferentialDrivetrain: IYawProvider {
    val left: Gearbox
    val right: Gearbox

    val yawSensor: IYawProvider

    val geometry: DifferentialDrivetrainGeometry

    override fun getYaw() = yawSensor.getYaw()
    override fun setYaw(value: AngularDistanceMeasureDegrees) = yawSensor.setYaw(value)

    /**
     * Applies "tank" controls to the gearboxes, in percent output mode.
     * In this mode, a left and right percentage out are passed directly to the left and right gearboxes.
     */
    fun tank(leftPercent: Double, rightPercent: Double) {
        left.setPercentOutput(leftPercent)
        right.setPercentOutput(rightPercent)
    }

    /**
     * Applies "arcade" controls to the gearboxes, in percent output mode.
     * In this mode, a translation and rotation are mixed and passed to the left and right gearboxes.
     */
    fun arcade(translation: Double, rotation: Double) {
        left.setPercentOutput(translation + rotation)
        right.setPercentOutput(translation - rotation)
    }

    /**
     * Stops the drivetrain.  This calls the "stop" method on both the left and right gearboxes
     */
    fun stop() {
        left.stop()
        right.stop()
    }
}