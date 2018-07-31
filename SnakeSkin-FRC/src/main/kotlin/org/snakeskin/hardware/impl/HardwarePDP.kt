package org.snakeskin.hardware.impl

import edu.wpi.first.wpilibj.PowerDistributionPanel
import org.snakeskin.hardware.PDP

/**
 * @author Cameron Earle
 * @version 7/31/18
 */
class HardwarePDP(override val hardwareObj: PowerDistributionPanel): PDP {
    override fun getCurrent(channel: Int): Double {
        return hardwareObj.getCurrent(channel)
    }

    override val temperature: Double
        get() = hardwareObj.temperature

    override val totalCurrent: Double
        get() = hardwareObj.totalCurrent

    override val totalEnergy: Double
        get() = hardwareObj.totalEnergy

    override val totalPower: Double
        get() = hardwareObj.totalPower

    override val voltage: Double
        get() = hardwareObj.voltage

    override fun resetTotalEnergy() {
        hardwareObj.resetTotalEnergy()
    }
}