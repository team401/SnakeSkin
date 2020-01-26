package org.snakeskin.component.impl

import com.ctre.phoenix.sensors.CANCoder
import org.snakeskin.component.ICanCoderDevice
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRevolutions
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRevolutionsPerSecond

/**
 * Hardware implementation of a CANCoder.  Device is assumed to be in its default configuration of degrees
 * for the distance unit, and seconds for the time unit.  Other configurations will result in incorrect values
 * returned by the functions of this class.
 */
class HardwareCanCoderDevice(val device: CANCoder): ICanCoderDevice {
    override fun getAngularPosition(): AngularDistanceMeasureRevolutions {
        return AngularDistanceMeasureRevolutions(device.position / 360.0)
    }

    override fun setAngularPosition(angle: AngularDistanceMeasureRevolutions) {
        device.position = angle.toDegrees().value
    }

    override fun getAngularVelocity(): AngularVelocityMeasureRevolutionsPerSecond {
        return AngularVelocityMeasureRevolutionsPerSecond(device.velocity / 360.0)
    }
}