package org.snakeskin.component.impl

import org.snakeskin.component.IDIOEncoderDevice
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRevolutions
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRevolutionsPerSecond

/**
 * No-op implementation of a DIO Encocer
 */
open class NullDIOEncoderDevice private constructor(): IDIOEncoderDevice {
    companion object {
        val INSTANCE = NullDIOEncoderDevice()
    }

    override fun getAngularPosition(): AngularDistanceMeasureRevolutions {
        return AngularDistanceMeasureRevolutions(0.0)
    }

    override fun getAngularVelocity(): AngularVelocityMeasureRevolutionsPerSecond {
        return AngularVelocityMeasureRevolutionsPerSecond(0.0)
    }

    override fun setAngularPosition(angle: AngularDistanceMeasureRevolutions) {
        //no-op
    }
}