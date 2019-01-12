package org.snakeskin.component

import org.snakeskin.units.measure.distance.linear.LinearDistanceMeasure
import org.snakeskin.units.measure.velocity.linear.LinearVelocityMeasure

/**
 * @author Cameron Earle
 * @version 1/10/2019
 *
 */
interface ISensoredTankDrivetrain: ITankDrivetrain {
    override val left: ISensoredGearbox
    override val right: ISensoredGearbox

    fun getLeftLinearVelocity(): LinearVelocityMeasure
    fun getRightLinearVelocity(): LinearVelocityMeasure
    fun getAverageLinearVelocity(): LinearVelocityMeasure

    fun getLeftLinearPosition(): LinearDistanceMeasure
    fun getRightLinearPosition(): LinearDistanceMeasure
    fun getAverageLinearPosition(): LinearDistanceMeasure
}