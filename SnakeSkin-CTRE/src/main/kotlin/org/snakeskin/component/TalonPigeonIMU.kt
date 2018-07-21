package org.snakeskin.component

import com.ctre.phoenix.motorcontrol.can.TalonSRX
import com.ctre.phoenix.sensors.PigeonIMU

/**
 * @author Cameron Earle
 * @version 7/21/2018
 *
 *
 * Pigeon IMU wrapper that creates a pigeon IMU connected to a talon given only the ID of the talon
 * Useful for constructors where the talon hasn't actually been initialized yet
 */
class TalonPigeonIMU(id: Int): PigeonIMU(TalonSRX(id))