package org.snakeskin.hardware.impl

import org.snakeskin.hardware.PigeonIMU
import org.snakeskin.logic.LockingDelegate

/**
 * @author Cameron Earle
 * @version 8/1/18
 */
class SoftwarePigeonImu: PigeonIMU {
    override val hardwareObj: Nothing? = null

    //Simulation environment
    var yawDegrees by LockingDelegate(0.0)

    override fun getYawPitchRoll(array: DoubleArray) {
        array[0] = yawDegrees
    }

    override fun setYaw(ctreNative: Double, timeoutMs: Int) {
        yawDegrees = ctreNative * 64.0
    }
}