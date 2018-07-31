package org.snakeskin.hardware.impl

import com.ctre.phoenix.motorcontrol.IMotorController
import org.snakeskin.hardware.VictorSPX

/**
 * @author Cameron Earle
 * @version 7/31/18
 */
class HardwareVictorSPX(override val hardwareObj: com.ctre.phoenix.motorcontrol.can.VictorSPX): VictorSPX, IMotorController by hardwareObj