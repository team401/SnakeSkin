package org.snakeskin.hardware

import org.snakeskin.hardware.impl.HardwareSolenoid
import org.snakeskin.hardware.impl.IntegerHardwareIdentifier
import org.snakeskin.hardware.impl.SoftwareSolenoid

/**
 * @author Cameron Earle
 * @version 7/30/2018
 *
 * Class for creating FRC hardware objects.  This includes some commonly used WPILib objects.
 */
object FRCHardware {
    enum class Type: HardwareType {
        SOLENOID
    }

    private inline fun <T> switch(hardware: () -> T, software: () -> T): T {
        return when (Hardware.environment) {
            Environment.HARDWARE -> hardware()
            Environment.SOFTWARE -> software()
        }
    }

    fun solenoid(id: Int, pcmId: Int = 0): Solenoid {
        val solenoid = switch({HardwareSolenoid(id, pcmId)}, {SoftwareSolenoid()})
        Hardware.addHardware(HardwareKey(Type.SOLENOID, PCMHardwareIdentifier(id, pcmId)), solenoid)
        return solenoid
    }
}