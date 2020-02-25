package org.snakeskin.component.impl

import edu.wpi.first.wpilibj.Encoder
import org.snakeskin.component.IDIOEncoderDevice
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRadians
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRadiansPerSecond

class HardwareDIOEncoderDevice(val device: Encoder, ticksPerRev: Double): IDIOEncoderDevice {
    private val scale = device.encodingScale //Grab this for converting velocities
    private var offset = AngularDistanceMeasureRadians(0.0)
    private val ticksPerRadian = ticksPerRev / (2.0 * Math.PI)

    override fun getAngularPosition(): AngularDistanceMeasureRadians {
        return AngularDistanceMeasureRadians(device.raw / ticksPerRadian) + offset
    }
    
    override fun setAngularPosition(angle: AngularDistanceMeasureRadians) {
        device.reset()
        offset = angle
    }

    override fun getAngularVelocity(): AngularVelocityMeasureRadiansPerSecond {
        return AngularVelocityMeasureRadiansPerSecond((device.rate * scale) / ticksPerRadian)
    }

    override fun invertInput(invert: Boolean) {
        device.setReverseDirection(invert)
    }
}