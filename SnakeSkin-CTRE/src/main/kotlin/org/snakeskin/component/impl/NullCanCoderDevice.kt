package org.snakeskin.component.impl

import org.snakeskin.component.ICanCoderDevice
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRadians
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRadiansPerSecond

/**
 * No-op implementation of the CANCoder
 */
open class NullCanCoderDevice private constructor() : ICanCoderDevice {
    companion object {
        val INSTANCE = NullCanCoderDevice()
        val producer = { INSTANCE }
    }

    override fun getAngularPosition(): AngularDistanceMeasureRadians {
        return AngularDistanceMeasureRadians(0.0)
    }

    override fun setAngularPosition(angle: AngularDistanceMeasureRadians) {
        //no-op
    }

    override fun getAngularVelocity(): AngularVelocityMeasureRadiansPerSecond {
        return AngularVelocityMeasureRadiansPerSecond(0.0)
    }

    override fun invertInput(invert: Boolean) {
        //no-op
    }
}