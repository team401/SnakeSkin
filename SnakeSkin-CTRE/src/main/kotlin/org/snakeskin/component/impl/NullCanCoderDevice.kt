package org.snakeskin.component.impl

import org.snakeskin.component.ICanCoderDevice
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRevolutions
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRevolutionsPerSecond

/**
 * No-op implementation of the CANCoder
 */
open class NullCanCoderDevice private constructor() : ICanCoderDevice {
    companion object {
        val INSTANCE = NullCanCoderDevice()
        val producer = { INSTANCE }
    }

    override fun getAngularPosition(): AngularDistanceMeasureRevolutions {
        return AngularDistanceMeasureRevolutions(0.0)
    }

    override fun setAngularPosition(angle: AngularDistanceMeasureRevolutions) {
        //no-op
    }

    override fun getAngularVelocity(): AngularVelocityMeasureRevolutionsPerSecond {
        return AngularVelocityMeasureRevolutionsPerSecond(0.0)
    }
}