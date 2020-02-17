package org.snakeskin.component.impl

import com.ctre.phoenix.sensors.PigeonIMU
import org.snakeskin.component.IPigeonImuDevice
import org.snakeskin.component.PigeonIMUYawMode
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureDegrees

class HardwarePigeonImuDevice(val device: PigeonIMU, val yawMode: PigeonIMUYawMode = PigeonIMUYawMode.FUSED): IPigeonImuDevice {
    private val ypr by lazy { DoubleArray(3) } //Only initialize this array if we need it

    @Synchronized override fun getYaw(): AngularDistanceMeasureDegrees {
        return when (yawMode) {
            PigeonIMUYawMode.FUSED -> AngularDistanceMeasureDegrees(device.fusedHeading)
            PigeonIMUYawMode.GYRO -> {
                device.getYawPitchRoll(ypr)
                AngularDistanceMeasureDegrees(ypr[0])
            }
        }
    }

    override fun setYaw(value: AngularDistanceMeasureDegrees) {
        when (yawMode) {
            PigeonIMUYawMode.FUSED -> device.fusedHeading = value.value
            PigeonIMUYawMode.GYRO -> device.setYaw(value.value)
        }
    }

    @Synchronized override fun getRoll(): AngularDistanceMeasureDegrees {
        device.getYawPitchRoll(ypr)
        return AngularDistanceMeasureDegrees(ypr[2])
    }

    @Synchronized override fun getPitch(): AngularDistanceMeasureDegrees {
        device.getYawPitchRoll(ypr)
        return AngularDistanceMeasureDegrees(ypr[1])
    }
}