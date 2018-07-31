package org.snakeskin.hardware.impl

import com.ctre.phoenix.motorcontrol.IMotorControllerEnhanced
import org.snakeskin.hardware.TalonSRX

/**
 * @author Cameron Earle
 * @version 7/31/18
 */
class HardwareTalonSRX(override val hardwareObj: com.ctre.phoenix.motorcontrol.can.TalonSRX): TalonSRX, IMotorControllerEnhanced by hardwareObj