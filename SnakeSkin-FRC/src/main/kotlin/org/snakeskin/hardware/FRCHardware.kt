package org.snakeskin.hardware

import edu.wpi.first.wpilibj.PWMSpeedController
import edu.wpi.first.wpilibj.PowerDistributionPanel
import org.snakeskin.hardware.impl.*

/**
 * @author Cameron Earle
 * @version 7/30/2018
 *
 * Class for creating FRC hardware objects.  This includes some commonly used WPILib objects.
 */
object FRCHardware {

    private inline fun <T> switch(hardware: () -> T, software: () -> T): T {
        return when (Hardware.environment) {
            Environment.HARDWARE -> hardware()
            Environment.SOFTWARE -> software()
        }
    }

    fun Solenoid(id: Int, pcmId: Int = 0): Solenoid {
        val solenoid = switch({HardwareSolenoid(edu.wpi.first.wpilibj.Solenoid(pcmId, id))}, {SoftwareSolenoid()})
        Hardware.addHardware("solenoids.$pcmId.$id", solenoid)
        return solenoid
    }

    private fun motorControllerPwm(id: Int, hardware: (Int) -> PWMSpeedController): MotorControllerPWM {
        val motorControllerPWM = switch({HardwareMotorControllerPWM(hardware(id))}, {SoftwareMotorControllerPWM()})
        Hardware.addHardware("pwm.$id", motorControllerPWM)
        return motorControllerPWM
    }

    fun VictorSP(id: Int) = motorControllerPwm(id) { edu.wpi.first.wpilibj.VictorSP(it) }
    fun Spark(id: Int) = motorControllerPwm(id) { edu.wpi.first.wpilibj.Spark(it) }

    fun PDP(id: Int = 0): PDP {
        val pdp = switch({HardwarePDP(PowerDistributionPanel(id))}, {SoftwarePDP()})
        Hardware.addHardware("can.pdp.$id", pdp)
        return pdp
    }
}