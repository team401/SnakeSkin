package org.snakeskin.component.impl

import org.snakeskin.component.IPigeonImuDevice
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureDegrees

/**
 * No-op implementation of the Pigeon IMU
 */
open class NullPigeonImuDevice private constructor(): IPigeonImuDevice {
    companion object {
        val INSTANCE = NullPigeonImuDevice()
        val producer = { INSTANCE }
    }

    override fun setYaw(value: AngularDistanceMeasureDegrees) {
        //no-op
    }

    override fun getYaw(): AngularDistanceMeasureDegrees {
        return AngularDistanceMeasureDegrees(0.0)
    }

    override fun getPitch(): AngularDistanceMeasureDegrees {
        return AngularDistanceMeasureDegrees(0.0)
    }

    override fun getRoll(): AngularDistanceMeasureDegrees {
        return AngularDistanceMeasureDegrees(0.0)
    }
}