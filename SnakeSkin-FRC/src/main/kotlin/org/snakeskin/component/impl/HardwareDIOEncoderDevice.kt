package org.snakeskin.component.impl

import edu.wpi.first.wpilibj.Encoder
import org.snakeskin.component.IDIOEncoderDevice
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRevolutions
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRevolutionsPerSecond

class HardwareDIOEncoderDevice(val device: Encoder, val ticksPerRev: Double): IDIOEncoderDevice {
    private val scale = device.encodingScale //Grab this for converting velocities

    override fun getAngularPosition(): AngularDistanceMeasureRevolutions {
        return AngularDistanceMeasureRevolutions(device.raw / ticksPerRev)
    }

    /**
     * Note: this implementation does not honor the angle, and instead sets it to zero
     */
    override fun setAngularPosition(angle: AngularDistanceMeasureRevolutions) {
        device.reset()
    }

    override fun getAngularVelocity(): AngularVelocityMeasureRevolutionsPerSecond {
        return AngularVelocityMeasureRevolutionsPerSecond((device.rate * scale) / ticksPerRev)
    }
}