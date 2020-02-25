package org.snakeskin.component.impl

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.can.VictorSPX
import org.snakeskin.component.IVictorSpxDevice
import org.snakeskin.component.provider.IFollowableProvider

class HardwareVictorSpxDevice(val device: VictorSPX): IVictorSpxDevice {
    override fun follow(master: IFollowableProvider) {
        when (master) {
            is HardwareTalonSrxDevice -> device.follow(master.device)
            is HardwareVictorSpxDevice -> device.follow(master.device)
        }
    }

    override fun unfollow() {
        //CTRE devices unfollow when a 0.0 percent output command is sent
        device.set(ControlMode.PercentOutput, 0.0)
    }

    override fun setPercentOutput(percentOut: Double) {
        device.set(ControlMode.PercentOutput, percentOut)
    }

    override fun getPercentOutput(): Double {
        return device.motorOutputPercent
    }

    override fun getOutputVoltage(): Double {
        return device.motorOutputVoltage
    }

    override fun getInputVoltage(): Double {
        return device.busVoltage
    }

    override fun stop() {
        setPercentOutput(0.0)
    }

    override fun invert(invert: Boolean) {
        device.inverted = invert
    }
}