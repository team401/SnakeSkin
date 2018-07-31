package org.snakeskin.hardware

import com.ctre.phoenix.motorcontrol.IMotorControllerEnhanced
import com.ctre.phoenix.motorcontrol.can.TalonSRX

/**
 * @author Cameron Earle
 * @version 7/31/18
 */
interface TalonSRX: IHardware<TalonSRX>, IMotorControllerEnhanced