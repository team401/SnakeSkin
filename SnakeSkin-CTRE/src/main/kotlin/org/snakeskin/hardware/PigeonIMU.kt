package org.snakeskin.hardware

import com.ctre.phoenix.sensors.PigeonIMU

/**
 * @author Cameron Earle
 * @version 8/1/18
 */
interface PigeonIMU: IHardware<PigeonIMU> {
    fun getYawPitchRoll(array: DoubleArray)
    fun setYaw(ctreNative: Double, timeoutMs: Int)
}