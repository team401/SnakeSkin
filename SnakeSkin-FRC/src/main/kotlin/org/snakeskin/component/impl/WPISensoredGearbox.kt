package org.snakeskin.component.impl

import edu.wpi.first.wpilibj.Encoder
import edu.wpi.first.wpilibj.PWMSpeedController
import org.snakeskin.component.ISensoredGearbox
import org.snakeskin.units.AngularDistanceUnit
import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasure
import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasureRadians
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasureRadiansPerSecond


/**
 * @author Cameron Earle
 * @version 1/9/2019
 *
 */
class WPISensoredGearbox(private val encoder: Encoder, vararg motorControllers: PWMSpeedController): WPIGearbox(*motorControllers), ISensoredGearbox {
    override fun getPositionRadians(): Double {
        return encoder.distance
    }

    override fun getVelocityRadiansPerSecond(): Double {
        return encoder.rate
    }

    override fun getPosition(): AngularDistanceMeasureRadians {
        return AngularDistanceMeasureRadians(getPositionRadians())
    }

    override fun getVelocity(): AngularVelocityMeasureRadiansPerSecond {
        return AngularVelocityMeasureRadiansPerSecond(getVelocityRadiansPerSecond())
    }

    /**
     * This implementation does not honor the position passed in, and
     * will instead set the encoder position to 0
     */
    override fun setPosition(position: AngularDistanceMeasure) {
        encoder.reset()
    }

    /**
     * This implementation will configure the encoder for radians per tick
     */
    override fun setDistancePerTick(dpt: AngularDistanceMeasure) {
        encoder.distancePerPulse = dpt.toUnit(AngularDistanceUnit.Standard.RADIANS).value
    }
}