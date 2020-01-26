package org.snakeskin.component

import com.ctre.phoenix.motorcontrol.can.TalonSRX
import com.ctre.phoenix.sensors.PigeonIMU
import com.ctre.phoenix.sensors.PigeonImuJNI

/**
 * @author Cameron Earle
 * @version 7/21/2018
 *
 * Pigeon IMU factory for pigeons connected to a Talon SRX.  Allows you to create a "ribbon pigeon" without
 * having a TalonSRX object available
 */
@Deprecated("Use component system equivalents")
object TalonPigeonIMU {
    /**
     * Creates a PigeonIMU object given the ID of the Talon SRX
     */
    fun create(talonId: Int): PigeonIMU {
        val handle = PigeonImuJNI.JNI_new_PigeonImu_Talon(talonId)
        val instance = PigeonIMU(0)
        val field1 = instance.javaClass.getDeclaredField("m_deviceNumber")
        val field2 = instance.javaClass.getDeclaredField("m_handle")
        field1.isAccessible = true
        field2.isAccessible = true
        field1.set(instance, talonId)
        field2.set(instance, handle)
        return instance
    }
}