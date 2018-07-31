package org.snakeskin.hardware.impl

import org.snakeskin.hardware.Hardware
import org.snakeskin.hardware.PDP
import org.snakeskin.logic.LockingDelegate
import java.util.*

/**
 * @author Cameron Earle
 * @version 7/31/18
 */
class SoftwarePDP: PDP {
    override val hardwareObj: Nothing? = null

    //Simulation environment
    var pdpVbusVoltage by LockingDelegate(0.0)
    var pdpTemperature by LockingDelegate(0.0)
    val pdpChannels = Vector<Double>(16)

    var pdpTotalEnergy by LockingDelegate(0.0)
    private var lastEnergyUpdate = Hardware.getRelativeTime()

    @Synchronized private fun updateTotalEnergy() {
        val time = Hardware.getRelativeTime()
        pdpTotalEnergy += totalPower / (time - lastEnergyUpdate)
        lastEnergyUpdate = time
    }

    private fun calculateTotalPower(): Double {
        var power = 0.0
        val v = pdpVbusVoltage
        for (channel in 0 until 16) {
            val i = pdpChannels[channel]
            power += (v * i)
        }
        return power
    }


    override fun getCurrent(channel: Int): Double {
        return pdpChannels[channel]
    }

    override val temperature: Double
        get() = pdpTemperature

    override val totalCurrent: Double
        get() = pdpChannels.sum()

    override val totalPower: Double
        get() = calculateTotalPower()

    override val totalEnergy: Double
        get() = pdpTotalEnergy

    override val voltage: Double
        get() = pdpVbusVoltage

    override fun resetTotalEnergy() {
        pdpTotalEnergy = 0.0
    }
}

