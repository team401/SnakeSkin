package org.snakeskin.units.measure.velocity.angular

import org.snakeskin.units.AngularVelocityUnit
import org.snakeskin.units.measure.Measure
import org.snakeskin.units.measure.velocity.linear.LinearVelocityMeasure

/**
 * @author Cameron Earle
 * @version 7/14/2018
 *
 */
interface AngularVelocityMeasure: Measure<AngularVelocityUnit, AngularVelocityMeasure> {
    companion object {
        fun create(value: Double, unit: AngularVelocityUnit): AngularVelocityMeasure {
            return when (unit) {
                AngularVelocityUnit.Standard.REVOLUTIONS_PER_SECOND -> AngularVelocityMeasureRevolutionsPerSecond(value)
                AngularVelocityUnit.Standard.REVOLUTIONS_PER_MINUTE -> AngularVelocityMeasureRevolutionsPerMinute(value)
                AngularVelocityUnit.Standard.RADIANS_PER_SECOND -> AngularVelocityMeasureRadiansPerSecond(value)
                AngularVelocityUnit.Standard.DEGREES_PER_SECOND -> AngularVelocityMeasureDegreesPerSecond(value)
                else -> unit.createMeasure()
            }
        }
    }
}