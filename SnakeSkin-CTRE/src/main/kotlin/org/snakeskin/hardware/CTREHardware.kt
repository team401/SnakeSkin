package org.snakeskin.hardware

import org.snakeskin.component.TalonPigeonIMU
import org.snakeskin.hardware.impl.*

/**
 * @author Cameron Earle
 * @version 7/31/18
 *
 * Class for creating CTRE hardware objects.  This includes Talon SRX, Victor SPX,
 */
object CTREHardware {

    private inline fun <T> switch(hardware: () -> T, software: () -> T): T {
        return when (Hardware.environment) {
            Environment.HARDWARE -> hardware()
            Environment.SOFTWARE -> software()
        }
    }

    fun TalonSRX(id: Int): TalonSRX {
        val talonSRX = switch({HardwareTalonSRX(com.ctre.phoenix.motorcontrol.can.TalonSRX(id))}, {SoftwareTalonSRX()})
        Hardware.addHardware("can.talonsrx.$id", talonSRX)
        return talonSRX
    }

    fun VictorSPX(id: Int): VictorSPX {
        val victorSPX = switch({HardwareVictorSPX(com.ctre.phoenix.motorcontrol.can.VictorSPX(id))}, {SoftwareVictorSPX()})
        Hardware.addHardware("can.victorspx.$id", victorSPX)
        return victorSPX
    }

    fun PigeonIMU(id: Int): PigeonIMU {
        val pigeonIMU = switch({HardwarePigeonIMU(com.ctre.phoenix.sensors.PigeonIMU(id))}, {SoftwarePigeonImu()})
        Hardware.addHardware("can.pigeonimu.$id", pigeonIMU)
        return pigeonIMU
    }

    fun TalonPigeonIMU(talonId: Int): PigeonIMU {
        val pigeonIMU = switch({HardwarePigeonIMU(org.snakeskin.component.TalonPigeonIMU(talonId))}, {SoftwarePigeonImu()})
        Hardware.addHardware("can.talonsrx.$talonId.pigeonimu", pigeonIMU)
        return pigeonIMU
    }
}