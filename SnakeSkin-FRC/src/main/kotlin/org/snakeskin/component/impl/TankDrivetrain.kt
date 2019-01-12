package org.snakeskin.component.impl

import org.snakeskin.component.IGearbox
import org.snakeskin.component.ITankDrivetrain
import org.snakeskin.units.measure.distance.linear.LinearDistanceMeasure

/**
 * @author Cameron Earle
 * @version 1/9/2019
 *
 */
open class TankDrivetrain(override val left: IGearbox, override val right: IGearbox): ITankDrivetrain {
    override var wheelRadius: LinearDistanceMeasure
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}

    override var wheelbase: LinearDistanceMeasure
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}

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