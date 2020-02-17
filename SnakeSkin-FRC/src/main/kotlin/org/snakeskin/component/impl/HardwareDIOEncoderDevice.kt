package org.snakeskin.component.impl

import edu.wpi.first.wpilibj.Encoder
import org.snakeskin.component.IDIOEncoderDevice
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRevolutions
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRevolutionsPerSecond

class HardwareDIOEncoderDevice(val device: Encoder, val ticksPerRev: Double): IDIOEncoderDevice {
    private val scale = device.encodingScale //Grab this for converting velocities
    private var offset = AngularDistanceMeasureRevolutions(0.0)

    override fun getAngularPosition(): AngularDistanceMeasureRevolutions {
        return AngularDistanceMeasureRevolutions(device.raw / ticksPerRev) + offset
    }
    
    override fun setAngularPosition(angle: AngularDistanceMeasureRevolutions) {
        device.reset()
        offset = angle
    }

    override fun getAngularVelocity(): AngularVelocityMeasureRevolutionsPerSecond {
        return AngularVelocityMeasureRevolutionsPerSecond((device.rate * scale) / ticksPerRev)
    }

    override fun invertInput(invert: Boolean) {
        device.setReverseDirection(invert)
    }
}