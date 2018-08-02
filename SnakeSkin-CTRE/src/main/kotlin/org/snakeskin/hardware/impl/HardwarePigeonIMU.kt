package org.snakeskin.hardware.impl

import org.snakeskin.hardware.PigeonIMU

/**
 * @author Cameron Earle
 * @version 8/1/18
 */
class HardwarePigeonIMU(override val hardwareObj: com.ctre.phoenix.sensors.PigeonIMU): PigeonIMU {
    override fun getYawPitchRoll(array: DoubleArray) {
        hardwareObj.getYawPitchRoll(array)
    }

    override fun setYaw(ctreNative: Double, timeoutMs: Int) {
        hardwareObj.setYaw(ctreNative, timeoutMs)
    }
}