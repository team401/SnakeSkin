package org.snakeskin.component.impl

import edu.wpi.first.wpilibj.Encoder
import edu.wpi.first.wpilibj.SpeedController
import org.snakeskin.component.ISensoredGearbox
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRadians
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRadiansPerSecond


/**
 * @author Cameron Earle
 * @version 1/9/2019
 *
 */
open class WPISensoredGearbox(private val encoder: Encoder, vararg motorControllers: SpeedController,
                         radiansPerTick: Double): WPIGearbox(*motorControllers), ISensoredGearbox {
    init {
        encoder.distancePerPulse = radiansPerTick
    }

    override fun getPosition(): AngularDistanceMeasureRadians {
        return AngularDistanceMeasureRadians(encoder.distance)
    }

    override fun getVelocity(): AngularVelocityMeasureRadiansPerSecond {
        return AngularVelocityMeasureRadiansPerSecond(encoder.rate)
    }

    /**
     * This implementation does not honor the position passed in, and
     * will instead set the encoder position to 0
     */
    override fun setPosition(position: AngularDistanceMeasureRadians) {
        encoder.reset()
    }
}