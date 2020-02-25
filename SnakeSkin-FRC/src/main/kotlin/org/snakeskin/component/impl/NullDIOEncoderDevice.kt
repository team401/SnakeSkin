package org.snakeskin.component.impl

import org.snakeskin.component.IDIOEncoderDevice
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRadians
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRadiansPerSecond

/**
 * No-op implementation of a DIO Encocer
 */
open class NullDIOEncoderDevice private constructor(): IDIOEncoderDevice {
    companion object {
        val INSTANCE = NullDIOEncoderDevice()
        val producer = { INSTANCE }
    }

    override fun getAngularPosition(): AngularDistanceMeasureRadians {
        return AngularDistanceMeasureRadians(0.0)
    }

    override fun getAngularVelocity(): AngularVelocityMeasureRadiansPerSecond {
        return AngularVelocityMeasureRadiansPerSecond(0.0)
    }

    override fun setAngularPosition(angle: AngularDistanceMeasureRadians) {
        //no-op
    }

    override fun invertInput(invert: Boolean) {
        //no-op
    }
}