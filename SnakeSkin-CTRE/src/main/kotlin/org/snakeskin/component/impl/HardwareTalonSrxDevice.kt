package org.snakeskin.component.impl

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.DemandType
import com.ctre.phoenix.motorcontrol.can.TalonSRX
import org.snakeskin.component.FeedforwardScalingMode
import org.snakeskin.component.ITalonSrxDevice
import org.snakeskin.component.provider.IFollowableProvider
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRevolutions
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRevolutionsPerSecond

class HardwareTalonSrxDevice(val device: TalonSRX, val sensorTicksPerRevolution: Double = 4096.0, val ffMode: FeedforwardScalingMode = FeedforwardScalingMode.SCALE_12V) : ITalonSrxDevice {
    private fun scaleFfVolts(voltage: Double): Double {
        return when (ffMode) {
            FeedforwardScalingMode.SCALE_12V -> voltage / 12.0
            FeedforwardScalingMode.SCALE_VBUS -> {
                val vbus = getInputVoltage()
                voltage / vbus
            }
        }
    }

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

    override fun getInputVoltage(): Double {
        return device.busVoltage
    }

    override fun getOutputVoltage(): Double {
        return device.motorOutputVoltage
    }

    override fun stop() {
        setPercentOutput(0.0)
    }

    override fun getRotationalPosition(): AngularDistanceMeasureRevolutions {
        val ticks = device.selectedSensorPosition.toDouble()
        return AngularDistanceMeasureRevolutions(ticks / sensorTicksPerRevolution)
    }

    override fun setRotationalPosition(angle: AngularDistanceMeasureRevolutions) {
        val ticks = (angle.value * sensorTicksPerRevolution).toInt()
        device.selectedSensorPosition = ticks
    }

    override fun getRotationalVelocity(): AngularVelocityMeasureRevolutionsPerSecond {
        val ticks = device.selectedSensorVelocity.toDouble()
        return AngularVelocityMeasureRevolutionsPerSecond((ticks / sensorTicksPerRevolution) * 10.0) //Multiply by 10 to convert deciseconds (100 ms) to seconds
    }

    override fun getOutputCurrent(): Double {
        return device.outputCurrent
    }

    override fun setAngularPositionSetpoint(setpoint: AngularDistanceMeasureRevolutions, ffVolts: Double) {
        val ticks = setpoint.value * sensorTicksPerRevolution
        val ffPercent = scaleFfVolts(ffVolts)
        device.set(ControlMode.Position, ticks, DemandType.ArbitraryFeedForward, ffPercent)
    }

    override fun setAngularVelocitySetpoint(setpoint: AngularVelocityMeasureRevolutionsPerSecond, ffVolts: Double) {
        val ticksPer100Ms = (setpoint.value * sensorTicksPerRevolution) / 10.0 //Divide by 10 to convert seconds to deciseconds (100 ms)
        val ffPercent = scaleFfVolts(ffVolts)
        device.set(ControlMode.Velocity, ticksPer100Ms, DemandType.ArbitraryFeedForward, ffPercent)
    }
}