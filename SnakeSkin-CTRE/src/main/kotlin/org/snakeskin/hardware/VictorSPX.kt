package org.snakeskin.hardware

import com.ctre.phoenix.motorcontrol.IMotorController
import com.ctre.phoenix.motorcontrol.can.VictorSPX

/**
 * @author Cameron Earle
 * @version 7/31/18
 */
interface VictorSPX: IHardware<VictorSPX>, IMotorController