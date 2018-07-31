package org.snakeskin.hardware

import edu.wpi.first.wpilibj.PowerDistributionPanel

/**
 * @author Cameron Earle
 * @version 7/31/18
 */
interface PDP: IHardware<PowerDistributionPanel> {
    fun getCurrent(channel: Int): Double
    val temperature: Double
    val totalCurrent: Double
    val totalEnergy: Double
    val totalPower: Double
    val voltage: Double

    fun resetTotalEnergy()
}