package org.snakeskin.component.impl

import org.snakeskin.component.IGearbox
import org.snakeskin.component.IDifferentialDrivetrain
import org.snakeskin.measure.distance.linear.LinearDistanceMeasureInches
import org.snakeskin.template.TankDrivetrainGeometryTemplate

/**
 * @author Cameron Earle
 * @version 1/9/2019
 *
 */
open class DifferentialDrivetrain<G: IGearbox>(override val left: G, override val right: G, geometry: TankDrivetrainGeometryTemplate): IDifferentialDrivetrain<G> {
    override fun updateGeometry(template: TankDrivetrainGeometryTemplate) {
        wheelRadius = template.wheelRadius
        wheelbase = template.wheelbase
    }

    override var wheelRadius: LinearDistanceMeasureInches = geometry.wheelRadius
    override var wheelbase: LinearDistanceMeasureInches = geometry.wheelbase

    override fun tank(leftSetpoint: Double, rightSetpoint: Double) {
        left.set(leftSetpoint)
        right.set(rightSetpoint)
    }

    override fun arcade(translation: Double, rotation: Double) {
        left.set(translation + rotation)
        right.set(translation - rotation)
    }

    override fun stop() {
        left.stop()
        right.stop()
    }
}