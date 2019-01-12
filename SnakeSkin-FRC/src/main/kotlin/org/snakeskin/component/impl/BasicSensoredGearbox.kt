package org.snakeskin.component.impl

import edu.wpi.first.wpilibj.Encoder
import edu.wpi.first.wpilibj.PWMSpeedController
import org.snakeskin.component.ISensoredGearbox
import org.snakeskin.units.AngularDistanceUnit
import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasure
import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasureDegrees
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasure
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasureDegreesPerSecond


/**
 * @author Cameron Earle
 * @version 1/9/2019
 *
 */
class BasicSensoredGearbox(private val encoder: Encoder, vararg motorControllers: PWMSpeedController): BasicGearbox(*motorControllers), ISensoredGearbox {
    override fun getPosition(): AngularDistanceMeasure {
        return AngularDistanceMeasureDegrees(encoder.distance)
    }

    override fun getVelocity(): AngularVelocityMeasure {
        return AngularVelocityMeasureDegreesPerSecond(encoder.rate)
    }

    override fun resetPosition() {
        encoder.reset()
    }

    override fun setDistancePerTick(dpt: AngularDistanceMeasure) {
        encoder.distancePerPulse = dpt.toUnit(AngularDistanceUnit.Standard.DEGREES).value
    }
}