package org.snakeskin.units.measure.velocity.angular

import org.snakeskin.units.*
import org.snakeskin.units.measure.Measure
import org.snakeskin.units.measure.distance.linear.LinearDistanceMeasure
import org.snakeskin.units.measure.velocity.linear.LinearVelocityMeasure
import org.snakeskin.units.measure.velocity.linear.LinearVelocityMeasureInchesPerSecond

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 */
interface AngularVelocityMeasure: Measure<AngularVelocityUnit, AngularVelocityMeasure> {
    /**
     * Converts this angular velocity into a linear velocity given a radius
     *
     * Calculation is done in radians per second, output unit is unit of the radius per second
     */
    fun toLinearVelocity(radius: LinearDistanceMeasure): LinearVelocityMeasure {
        return LinearVelocityMeasure.create(
                this.toUnit(AngularVelocityUnit.Standard.RADIANS_PER_SECOND).value * radius.value,
                radius.unit.createLinearVelocityUnit(TimeUnit.Standard.SECONDS)
        )
    }

    companion object {
        fun create(value: Double, unit: AngularVelocityUnit): AngularVelocityMeasure {
            return when (unit) {
                AngularVelocityUnit.Standard.REVOLUTIONS_PER_SECOND -> AngularVelocityMeasureRevolutionsPerSecond(value)
                AngularVelocityUnit.Standard.REVOLUTIONS_PER_MINUTE -> AngularVelocityMeasureRevolutionsPerMinute(value)
                AngularVelocityUnit.Standard.RADIANS_PER_SECOND -> AngularVelocityMeasureRadiansPerSecond(value)
                AngularVelocityUnit.Standard.DEGREES_PER_SECOND -> AngularVelocityMeasureDegreesPerSecond(value)
                else -> unit.createMeasure(value)
            }
        }
    }
}