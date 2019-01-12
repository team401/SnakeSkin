package org.snakeskin.component.impl

import org.snakeskin.component.ISensoredGearbox
import org.snakeskin.component.ISensoredTankDrivetrain
import org.snakeskin.units.measure.distance.linear.LinearDistanceMeasure
import org.snakeskin.units.measure.velocity.linear.LinearVelocityMeasure

/**
 * @author Cameron Earle
 * @version 1/9/2019
 *
 */
class SensoredTankDrivetrain(override val left: ISensoredGearbox, override val right: ISensoredGearbox): TankDrivetrain(left, right), ISensoredTankDrivetrain {
    override fun getLeftLinearVelocity(): LinearVelocityMeasure {
        return left.getVelocity().toLinearVelocity(wheelRadius)
    }

    override fun getRightLinearVelocity(): LinearVelocityMeasure {
        return right.getVelocity().toLinearVelocity(wheelRadius)
    }

    override fun getAverageLinearVelocity(): LinearVelocityMeasure {
        return (getLeftLinearVelocity() + getRightLinearVelocity()) / 2.0
    }

    override fun getLeftLinearPosition(): LinearDistanceMeasure {
        return left.getPosition().toLinearDistance(wheelRadius)
    }

    override fun getRightLinearPosition(): LinearDistanceMeasure {
        return right.getPosition().toLinearDistance(wheelRadius)
    }

    override fun getAverageLinearPosition(): LinearDistanceMeasure {
        return (getLeftLinearPosition() + getRightLinearPosition()) / 2.0
    }
}