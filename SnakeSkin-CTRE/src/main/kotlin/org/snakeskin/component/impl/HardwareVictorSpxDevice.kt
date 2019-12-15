package org.snakeskin.component.impl

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.can.VictorSPX
import org.snakeskin.component.IVictorSpxDevice
import org.snakeskin.component.provider.IFollowableProvider

//TODO
//TODO
//TODO FINISH THIS CLASS.
class HardwareVictorSpxDevice(val device: VictorSPX): IVictorSpxDevice {
    override fun follow(master: IFollowableProvider) {
        when (master) {
            is HardwareTalonSrxDevice -> device.follow(master.device)
            is HardwareVictorSpxDevice -> device.follow(master.device)
        }
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

    override fun stop() {
        setPercentOutput(0.0)
    }

    override fun unfollow() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}